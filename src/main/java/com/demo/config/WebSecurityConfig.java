package com.demo.config;

import com.demo.service.UserDetailServiceImpl;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(2)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailServiceImpl userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .antMatcher("/**").authorizeRequests()//Toàn bộ request Matcher /** đều do class này xử lý
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/", "/index").permitAll() // Cho phép tất cả truy cập vào 2 uri này
                .antMatchers("/admin").hasAuthority("ADMIN")//hasAuthority không chứa role prefix ROLE_
                .antMatchers("/user").hasAuthority("USER")
                .anyRequest().authenticated()
//                    .antMatchers("/user").hasRole("USER") //hasRole có chứa role prefix ROLE_
                .and()
                .formLogin() // Cho phép user xác thực bằng form login
//                    .loginPage("/login")//Custom trang login
//                    .usernameParameter("username")
//                    .passwordParameter("password")
                .defaultSuccessUrl("/admin")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .permitAll() // Enable logout
                .and()
                .exceptionHandling()
                .accessDeniedPage("/401");
        http.sessionManagement().maximumSessions(1).expiredUrl("/login?expired=true");

    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/", "/ok", "/token/**", "/images/**", "/videos/**", "/api/public/**", "/api/**");
//    }
}
