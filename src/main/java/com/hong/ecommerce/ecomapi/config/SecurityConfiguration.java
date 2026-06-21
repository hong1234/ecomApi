package com.hong.ecommerce.ecomapi.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // http
        //         .authorizeHttpRequests((authz) -> authz
        //             .anyRequest().authenticated())
        //         .httpBasic(Customizer.withDefaults());

        http
        .csrf((csrf) -> csrf.disable())
        // .cors(Customizer.withDefaults())
        .cors(c -> {
            CorsConfigurationSource source = request -> {
                CorsConfiguration config = new CorsConfiguration();
                // config.setAllowedOrigins(List.of("http://localhost:3000", "example.com", "example.org")); 
                config.setAllowedOrigins(List.of("*"));
                config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                config.setAllowedHeaders(List.of("*"));
                return config;
            };
            c.configurationSource(source);
        })
        .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
            .anyRequest().permitAll()
        );
        return http.build();
    }

}
