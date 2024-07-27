package moheng.auth.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import moheng.auth.exception.InvalidTokenException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JwtTokenProviderTest {
    private static final String SECRET_KEY = "secret_secret_secret_secret_secret_secret_secret_";
    private static final int EXPIRE_TIME = 3600;
    private final JwtTokenProvider jwtTokenProvider = new JwtTokenProvider(SECRET_KEY, EXPIRE_TIME);

    @DisplayName("JWT 토큰을 생성한다.")
    @Test
    void JWT_토큰을_생성한다() {
        // given
        String payload = "hello";

        // when
        String actual = jwtTokenProvider.createToken(payload);

        // then
        assertThat(actual.split("\\.")).hasSize(3);
    }

    @DisplayName("JWT 토큰의 Payload 를 조회한다.")
    @Test
    void JWT_토큰의_Payload_를_조회한다() {
        // given
        String exptected = "hello";
        String token = jwtTokenProvider.createToken(exptected);

        // when
        String actual = jwtTokenProvider.getPayload(token);

        // then
        assertThat(actual).isEqualTo(exptected);
    }

    @DisplayName("만료된 토큰을 전달받으면 예외가 발생한다.")
    @Test
    void 만료된_토큰을_전달받으면_예외가_발생한다() {
        // given
        JwtTokenProvider expiredJwtTokenProvider = new JwtTokenProvider(SECRET_KEY, 0);
        String expiredToken = expiredJwtTokenProvider.createToken("payload");

        // when & then
        assertThatThrownBy(() -> jwtTokenProvider.validateToken(expiredToken))
                .isInstanceOf(InvalidTokenException.class);
    }
}
