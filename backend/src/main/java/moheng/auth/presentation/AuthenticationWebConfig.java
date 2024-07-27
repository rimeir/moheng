package moheng.auth.presentation;

import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Component
public class AuthenticationWebConfig implements WebMvcConfigurer {
    private final AuthenticationArgumentResolver authenticationArgumentResolver;

    public AuthenticationWebConfig(final AuthenticationArgumentResolver authenticationArgumentResolver) {
        this.authenticationArgumentResolver = authenticationArgumentResolver;
    }

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(authenticationArgumentResolver);
    }
}
