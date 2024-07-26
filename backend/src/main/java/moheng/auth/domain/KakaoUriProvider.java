package moheng.auth.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KakaoUriProvider implements OAuthUriProvider {
    private static final String KAKAO_OAUTH_END_POINT = "";
    private final String redirectUri;
    private final String clientId;
    private final String clientSecret;

    public KakaoUriProvider(@Value("${oauth.kakao.redirect_uri}") final String redirectUri,
                       @Value("${oauth.kakao.redirect_uri}") final String clientId,
                       @Value("${oauth.kakao.client_secret}") final String clientSecret) {
        this.redirectUri = redirectUri;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    public String generateUri(String code) {
        return KAKAO_OAUTH_END_POINT + "?"
                + "client_id=" + clientId + "&"
                + "redirect_uri=" + redirectUri + "&"
                + "response_type=code&";
    }
}
