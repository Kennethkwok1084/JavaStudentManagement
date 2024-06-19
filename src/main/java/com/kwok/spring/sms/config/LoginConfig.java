package com.kwok.spring.sms.config;

import com.kwok.spring.sms.Interceptor.AdminInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {

    private static final String[] STATIC_RESOURCES = new String[] {
            "/**/*.html", "/**/*.js", "/**/*.css",
            "/**/*.ico", "/**/*.jpg", "/**/*.png",
            "/**/*.woff", "/**/*.ttf"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new AdminInterceptor());
        registration.addPathPatterns("/**"); // 拦截所有路径
        registration.excludePathPatterns("/login", "/captcha"); // 排除登录和验证码路径
        registration.excludePathPatterns(STATIC_RESOURCES); // 排除静态资源
    }
}
