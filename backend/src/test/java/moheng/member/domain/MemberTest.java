package moheng.member.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import moheng.member.exception.InvalidEmailFormatException;
import moheng.member.exception.InvalidNicknameFormatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberTest {

    @DisplayName("카카오 소셜로그인 회원을 생성한다.")
    @Test
    public void 카카오_소셜로그인_회원을_생성한다() {
        // given, when, then
        assertDoesNotThrow(() ->
                new Member("msung6924@naver.com", "msung99",
                        "profile_img_url", SocialType.KAKAO));
    }

    @DisplayName("구글 소셜로그인 회원을 생성한다.")
    @Test
    public void 구글_소셜로그인_회원을_생성한다() {
        // given, when, then
        assertDoesNotThrow(() ->
                new Member("msung6924@naver.com", "msung99",
                        "profile_img_url", SocialType.GOOGLE));
    }

    @DisplayName("이메일 형식이 올바르지 않다면 예외가 발생한다.")
    @Test
    public void 이메일_형식이_올바르지_않다면_예외가_발생한다() {
        // given, when, then
        assertThatThrownBy(() -> new Member("msung6924naver.com", "msung99",
                "profile_img_url", SocialType.KAKAO))
                .isInstanceOf(InvalidEmailFormatException.class);
    }

    @DisplayName("닉네임 형식이 올바르지 않다면 예외가 발생한다.")
    @Test
    public void 닉네임_형식이_올바르지_않다면_예외가_발생한다() {
        // given, when, then
        assertThatThrownBy(() -> new Member("msung6924@naver.com",
                "qweiqnweiqnweiqwieqniweiqweiqwneiqnweqwienwqeqieqnweiqwneiqwenqweiqnweiqweqweqweqweinqwneiqwei",
                "profile_img_url", SocialType.KAKAO))
                .isInstanceOf(InvalidNicknameFormatException.class);
    }
}
