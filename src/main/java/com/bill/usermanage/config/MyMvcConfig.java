package com.bill.usermanage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //使用这个注册访问的页面
        //registry.addViewController("/index.html").setViewName("index");
        ///index.html为访问的路径，index跳转的资源
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
//        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/forms.html").setViewName("forms");
        registry.addViewController("/charts.html").setViewName("charts");
//        registry.addViewController("/tables.html").setViewName("tables");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    /**
     * 资源拦截，url拦截，可以用srpingsecurity替代
     */
 /*   @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        拦截全部的请求，除了不需要登陆session的请求
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/login.html","/","/login","/css/**","/data/**","/fonts/**","/img/**","/js/**","/css/**","/vendor/**","/icons-reference/**","/druid/");
    }*/
}
