package com.ikeasistencia.ikepagos.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception{
        return http
            .csrf().disable()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .build();
    }

    @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("HeyBillyAdmin")
                .password(passwordEncoder().encode("hey_Billy&ike_asist3nci4"))
                .roles()
                .build());
        return manager;
    }

    @Bean
    AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
