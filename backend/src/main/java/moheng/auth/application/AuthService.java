package moheng.auth.application;

import moheng.auth.domain.OAuthClient;
import moheng.auth.domain.OAuthMember;
import moheng.auth.domain.OAuthUriProvider;
import moheng.auth.dto.TokenResponse;
import moheng.member.application.MemberService;
import moheng.member.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    private final OAuthUriProvider oAuthUriProvider;
    private final OAuthClient oAuthClient;
    private final MemberService memberService;

    public AuthService(final OAuthUriProvider oAuthUriProvider, final OAuthClient oAuthClient,
                       final MemberService memberService) {
        this.oAuthUriProvider = oAuthUriProvider;
        this.oAuthClient = oAuthClient;
        this.memberService = memberService;
    }

    @Transactional
    public TokenResponse generateTokenWithCode(final String code) {
        OAuthMember oAuthMember = oAuthClient.getOAuthmember(code);
        return new TokenResponse("access_token");
    }

    @Transactional(readOnly = true)
    public String generateUri() {
        return oAuthUriProvider.generateUri();
    }
}
