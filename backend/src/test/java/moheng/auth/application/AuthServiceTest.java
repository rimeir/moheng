package moheng.auth.application;

import moheng.auth.dto.TokenResponse;
import moheng.config.TestConfig;
import moheng.member.domain.Member;
import moheng.member.domain.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest(classes = TestConfig.class)
class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("카카오 로그인을 위한 링크를 생성한다.")
    @Test
    void 카카오_로그인을_위한_링크를_생성한다() {
        // given
        String code = "authorization_code";
        String link = authService.generateUri();

        // when, then
        assertThat(link).isNotEmpty();
    }

    @DisplayName("토큰 생성을 하면 OAuth 서버에서 인증 후 토큰을 반환한다")
    @Test
    void 토큰_생성을_하면_OAuth_서버에서_인증_후_토큰을_반환한다() {
        // given
        String code = "authorization code";

        // when
        TokenResponse actual = authService.generateTokenWithCode(code);

        // then
        assertThat(actual.getAccessToken()).isNotEmpty();
    }

    @DisplayName("Authorization Code 를 전달받으면 회원 정보가 데이터베이스에 저장된다.")
    @Test
    void Authorization_Code_를_전달받으면_회원_정보가_데이터베이스에_저장된다() {
        // given
        String code = "authorization code";
        authService.generateTokenWithCode(code);

        // when
        boolean actual = memberRepository.existsByEmail("stub@naver.com");

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("이미 가입된 회원에 대한 Authorization Code를 전달받으면 추가로 유저가 생성되지 않는다")
    @Test
    void 이미_가입된_회원에_대한_Authorization_Code를_전달받으면_유저가_추가로_생성되지_않는다() {
        // given
        String code = "authorization code";
        authService.generateTokenWithCode(code);

        // when, then
        authService.generateTokenWithCode(code);
        authService.generateTokenWithCode(code);
        authService.generateTokenWithCode(code);
        List<Member> actual = memberRepository.findAll();

        // then
        assertThat(actual).hasSize(1);
    }
}