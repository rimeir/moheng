package moheng.auth.presentation.admin;

import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Component
public class AdminAuthenticationWebConfig implements WebMvcConfigurer {
    private final AdminAuthenticationArgumentResolver adminAuthenticationArgumentResolver;

    public AdminAuthenticationWebConfig(final AdminAuthenticationArgumentResolver adminAuthenticationArgumentResolver) {
        this.adminAuthenticationArgumentResolver = adminAuthenticationArgumentResolver;
    }

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(adminAuthenticationArgumentResolver);
    }
}

