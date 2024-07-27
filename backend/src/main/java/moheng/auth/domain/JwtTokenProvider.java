package moheng.auth.domain;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import moheng.auth.exception.InvalidTokenException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private final SecretKey secretKey;
    private final long tokenValidityInSeconds;

    public JwtTokenProvider(@Value("${security.jwt.token.secret_key}") final String secretKey,
                            @Value("${security.jwt.token.expire_length}") final long tokenValidityInSeconds) {
        this.secretKey = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        this.tokenValidityInSeconds = tokenValidityInSeconds;
    }

    public String createToken(String payload) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + tokenValidityInSeconds);

        return Jwts.builder()
                .setSubject(payload)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String getPayload(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public void validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);

            claims.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            throw new InvalidTokenException("변조되었거나 만료된 토큰 입니다.");
        }
    }
}


