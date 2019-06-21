package com.example.ol.config;

import com.example.ol.web.AdminInterceptor;
import com.example.ol.web.UserInterceptor;
import com.example.ol.web.VipInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Resource
    private UserInterceptor userInterceptor;

    @Resource
    private VipInterceptor vipInterceptor;

    @Resource
    private AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor);
        registry.addInterceptor(vipInterceptor);
        registry.addInterceptor(adminInterceptor);
    }
}
