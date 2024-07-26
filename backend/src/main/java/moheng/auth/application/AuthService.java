package moheng.auth.application;

import moheng.auth.domain.OAuthUriProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final OAuthUriProvider oAuthUriProvider;

    public AuthService(OAuthUriProvider oAuthUriProvider) {
        this.oAuthUriProvider = oAuthUriProvider;
    }

    public String generateLink() {
        return oAuthUriProvider.generateUri();
    }
}
