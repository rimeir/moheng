package moheng.member.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberTest {

    @DisplayName("카카오 소셜로그인 회원을 생성한다.")
    @Test
    public void 카카오_소셜로그인_회원을_생성한다() {
        // given, when, then
        Assertions.assertDoesNotThrow(() ->
                new Member("msung6924@naver.com", "msung99",
                        "profile_img_url", SocialType.KAKAO));
    }

    @DisplayName("구글 소셜로그인 회원을 생성한다.")
    @Test
    public void 구글_소셜로그인_회원을_생성한다() {
        // given, when, then
        Assertions.assertDoesNotThrow(() ->
                new Member("msung6924@naver.com", "msung99",
                        "profile_img_url", SocialType.GOOGLE));
    }
}
