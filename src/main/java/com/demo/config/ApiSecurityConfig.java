package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@Order(1)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void setTrustResolver(AuthenticationTrustResolver trustResolver) {
        super.setTrustResolver(trustResolver);
    }

    @Autowired
    private CustomAuthEntryPoint customAuthEntryPoint;

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    AuthFilter authFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .antMatcher("/api/**") ////Toàn bộ request Matcher /api/** đều do class này xử lý
                .authorizeRequests()
                .antMatchers("/api/login", "/api/register").permitAll()
                .antMatchers("/api/home").hasAuthority("USER")
                .anyRequest().authenticated() //Toàn bộ request Matcher /api/** đều phải có token
                .and()
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().authenticationEntryPoint(customAuthEntryPoint);

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/","/ok","/token/**","/images/**","/videos/**","/api/public/**","/api/register/**","/api/login/**","/api/home/**");
//    }
}
