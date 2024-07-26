package moheng.auth.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @DisplayName("카카오 로그인을 위한 링크를 생성한다.")
    @Test
    void 카카오_로그인을_위한_링크를_생성한다() {
        // given
        String link = authService.generateLink();

        // when, then
        assertThat(link).isNotEmpty();
    }
}