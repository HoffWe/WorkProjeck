package com.example.workproject.config;

import com.example.workproject.service.UserAppService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserAppService userAppService;

    public SecurityConfiguration(UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers()
                .and()
                .authorizeRequests()
                .antMatchers("/task/**", "/message/**").authenticated()
                .antMatchers("/worker/all").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
