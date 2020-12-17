package com.bill.usermanage.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 授权拦截
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//    关闭csrf防御
        http.csrf().disable();
        //请求授权的规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/tables").hasRole("vip1")
                .antMatchers("/charts.html").hasRole("vip2")
                .antMatchers("/forms.html").hasRole("vip3");

        //没有权限跳转到登陆页面
        http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").defaultSuccessUrl("/").permitAll();
        //登出
        http.logout().logoutSuccessUrl("/");
        //记住我
        http.rememberMe().rememberMeCookieName("rememberme");

    }

    /**
     * 认证
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new Pbkdf2PasswordEncoder())
                .withUser("bill").password(new Pbkdf2PasswordEncoder().encode("1234")).roles("vip1","vip3");
    }

    /**
     * 资源放行
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers("/css/**","/data/**","/fonts/**","/icons-reference/**","/img/**","/js/**","/svg/**","/vendor/**");
    }
}
