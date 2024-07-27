package moheng.auth.presentation;

import jakarta.servlet.http.HttpServletRequest;
import moheng.auth.domain.JwtTokenProvider;
import moheng.auth.dto.LoginMember;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class AuthenticationArgumentResolver extends HandlerMethodArgumentResolver {
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationArgumentResolver(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String accessToken = request.getHeader("Authorization");
        jwtTokenProvider.validateToken(accessToken);
        Long id = Long.parseLong(jwtTokenProvider.getPayload(accessToken));
        return new LoginMember(id);
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {

    }
}
