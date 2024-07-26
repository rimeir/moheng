package moheng.auth.application;

import jakarta.transaction.Transactional;
import moheng.auth.domain.OAuthClient;
import moheng.auth.domain.OAuthMember;
import moheng.auth.domain.OAuthUriProvider;
import moheng.auth.dto.TokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final OAuthUriProvider oAuthUriProvider;
    private final OAuthClient oAuthClient;

    public AuthService(final OAuthUriProvider oAuthUriProvider, final OAuthClient oAuthClient) {
        this.oAuthUriProvider = oAuthUriProvider;
        this.oAuthClient = oAuthClient;
    }

    @Transactional
    public TokenResponse generateTokenWithCode(final String code) {
        OAuthMember oAuthMember = oAuthClient.getOAuthmember(code);
        return new TokenResponse("access_token");
    }

    public String generateTokenWithCode() {
        return oAuthUriProvider.generateUri();
    }
}
