package moheng.auth.domain;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class KakaoOAuthClient implements OAuthClient {

    @Override
    public OAuthMember getOAuthMember(final String code) {

    }
}
