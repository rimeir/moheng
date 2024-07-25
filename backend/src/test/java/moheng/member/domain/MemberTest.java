package moheng.member.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberTest {

    @DisplayName("회원을 생성한다.")
    @Test
    public void 회원을_생성한다() {
        // given, when, then
        Assertions.assertDoesNotThrow(() ->
                new Member("msung6924@naver.com", "msung99",
                        "profile_img_url", SocialType.KAKAO));
    }
}
