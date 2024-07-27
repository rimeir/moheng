package moheng.member.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import moheng.member.exception.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MemberTest {

    @DisplayName("카카오 소셜로그인 회원을 생성한다.")
    @Test
    public void 카카오_소셜로그인_회원을_생성한다() {
        // given, when, then
        assertDoesNotThrow(() ->
                new Member("msung6924@naver.com", SocialType.KAKAO));
    }

    @DisplayName("구글 소셜로그인 회원을 생성한다.")
    @Test
    public void 구글_소셜로그인_회원을_생성한다() {
        // given, when, then
        assertDoesNotThrow(() ->
                new Member("msung6924@naver.com", SocialType.GOOGLE));
    }

    @DisplayName("이메일 형식이 올바르지 않다면 예외가 발생한다.")
    @Test
    public void 이메일_형식이_올바르지_않다면_예외가_발생한다() {
        // given, when, then
        assertThatThrownBy(() -> new Member("msung6924naver.com", SocialType.KAKAO))
                .isInstanceOf(InvalidEmailFormatException.class);
    }

    @DisplayName("닉네임 형식이 올바르지 않다면 예외가 발생한다.")
    @Test
    public void 닉네임_형식이_올바르지_않다면_예외가_발생한다() {
        // given, when, then
        assertThatThrownBy(() -> new Member(1L, "msung6924@naver.com",
                "qweiqnweiqnweiqwieqniweiqweiqwneiqnweqwienwqeqieqnweiqwneiqwenqweiqnweiqweqweqweqweinqwneiqwei",
                "profile_img_url", SocialType.KAKAO, LocalDate.of(2000, 1, 1), GenderType.MEN))
                .isInstanceOf(InvalidNicknameFormatException.class);
    }

    @DisplayName("존재하지 않는 소셜 로그인 제공처라면 예외가 발생한다.")
    @Test
    public void 존재하지_않는_소셜_로그인_제공처라면_예외가_발생한다() {
        // given, when, then
        assertThatThrownBy(() -> new Member(1L, "msung6924@naver.com", "msung99",
                "profile_img_url", null, LocalDate.of(2000, 1, 1), GenderType.MEN))
                .isInstanceOf(NoExistSocialTypeException.class);
    }

    @DisplayName("성별 형식이 올바르지 않다면 예외가 발생한다.")
    @Test
    public void 성별_형식이_올바르지_않다면_예외가_발생한다() {
        // given, when, then
        assertThatThrownBy(() -> new Member(1L, "msung6924@naver.com",
                "msung99", "profile_img_url",
                SocialType.KAKAO, LocalDate.now(), null))
                .isInstanceOf(InvalidGenderFormatException.class);
    }

    @DisplayName("생년월일이 현재 날짜보다 이후라면 예외가 발생한다.")
    @Test
    public void 생년월일이_현재_날짜보다_이후라면_예외가_발생한다() {
        // given, when, then
        assertThatThrownBy(() -> new Member(1L, "msung6924@naver.com",
                "msung99", "profile_img_url",
                SocialType.KAKAO, LocalDate.of(2200, 1, 1), GenderType.MEN))
                .isInstanceOf(InvalidBirthdayException.class);
    }
}
