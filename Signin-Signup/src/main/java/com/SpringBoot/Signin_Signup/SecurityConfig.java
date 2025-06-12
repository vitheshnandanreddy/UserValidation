package com.SpringBoot.Signin_Signup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/index.html", "/register", "/login", "/reset","/welcome.html", "/images/**", "/script.js", "/ui.css", "/forgot.html", "/forgot.css").permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
    }
}