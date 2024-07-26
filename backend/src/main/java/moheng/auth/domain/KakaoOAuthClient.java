package moheng.auth.domain;

import org.springframework.stereotype.Component;

@Component
public class KakaoOAuthClient implements OAuthClient {

    @Override
    public OAuthMember getOAuthmember(String code) {
        return null;
    }
}
