package moheng.auth.presentation;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AuthenticationBearerExtractor {
    private static final String BEARER_TYPE = "Bearer ";

    public static String extract(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (Objects.isNull(authorizationHeader)) {
            throw new RuntimeException();
        }

        validateAuthorizationFormat(authorizationHeader);
        return authorizationHeader.substring(BEARER_TYPE.length()).trim();
    }

    private static void validateAuthorizationFormat(String authorizationHeader) {
        if (!authorizationHeader.toLowerCase().startsWith(BEARER_TYPE.toLowerCase())) {
            throw new RuntimeException();
        }
    }
}
