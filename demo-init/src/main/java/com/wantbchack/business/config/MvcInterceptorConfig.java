package com.wantbchack.business.config;

import com.wantbchack.business.interceptor.MyInterceptorAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Create by  fanxiaobin
 * Date 2022/6/28  16:07
 * Description
 */
@Configuration
public class MvcInterceptorConfig implements  WebMvcConfigurer {
    //需要拦截的地址,使用正则来规范
    final String[] InterceptPaths = {"/**"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptorAdapter()).addPathPatterns(InterceptPaths);
    }

}
