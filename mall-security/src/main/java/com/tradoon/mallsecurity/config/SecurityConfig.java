package com.tradoon.mallsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * author:tradoon
 * desciption:对SpringSecurity进行配置
 * date:
 */

public class SecurityConfig extends WebSecurityConfigurerAdapter {
   @Autowired
   IgnoreUrlsConfig ignoreUrlsConfig;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        //开启请求权限配置
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
        //不需要保护的资源路径允许访问
        for(String url: ignoreUrlsConfig.getUrls()){
            registry.antMatchers(url).permitAll();
        }
        //跨域

        //拦截其余
        registry.and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
        //动态配置
    }
    @Bean
   public  PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
}
}
