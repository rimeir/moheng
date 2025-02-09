package moheng.config;

import moheng.auth.domain.OAuthClient;
import moheng.auth.domain.OAuthMember;
import org.springframework.stereotype.Component;


public class StubOAuthClient implements OAuthClient {
    @Override
    public OAuthMember getOAuthMember(String code) {
        return new OAuthMember("stub@naver.com", "stub_login_id", "stub_nickname", "stub_image_url");
    }
}
