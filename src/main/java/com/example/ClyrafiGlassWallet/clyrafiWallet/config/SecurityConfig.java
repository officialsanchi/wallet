package com.example.ClyrafiGlassWallet.clyrafiWallet.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfig {
//    public SecurityConfig(ApiKeyFilter apiKeyFilter) {
//        this.apiKeyFilter = apiKeyFilter;
//    }
//
//    private final ApiKeyFilter apiKeyFilter;
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http.csrf().disable()
////                .addFilterBefore(apiKeyFilter, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/api/apikey/**").permitAll()
////                        .anyRequest().authenticated()
////                );
//        return http.build();
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
