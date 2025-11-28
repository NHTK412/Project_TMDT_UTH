package com.example.clothingstore.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.cors(cors -> cors.configurationSource((request) -> {

            CorsConfiguration corsConfiguration = new CorsConfiguration();

            corsConfiguration.setAllowedOrigins(List.of("*"));

            corsConfiguration.setAllowedMethods(List.of(
                    "GET",
                    "POST",
                    "PUT",
                    "DELETE",
                    "OPTIONS"));

            corsConfiguration.setAllowedHeaders(List.of(
                    "Authorization",
                    "Content-Type",
                    "Accept",
                    "Cache-Control",
                    "X-Requested-With",
                    "X-Client-Version",
                    "X-Refresh-Token"));

            corsConfiguration.setExposedHeaders(List.of("Authorization"));

            corsConfiguration.setAllowCredentials(null);

            return corsConfiguration;

        }));

        httpSecurity.csrf((csrf) -> csrf.disable());

        httpSecurity.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity.authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll()
                .anyRequest().permitAll());

        return httpSecurity.build();
    }
}
