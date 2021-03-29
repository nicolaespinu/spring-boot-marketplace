package com.spinic.market.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/market/products/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/market/products").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/market/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/market/products/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/market/products/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/market/products/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER")
                .and()
                .withUser("admin").password("{noop}admin").roles("USER", "ADMIN");
    }

}