package com.aliacar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        config.setAllowCredentials(true);
        config.setAllowedOriginPatterns(List.of("*")); // allowCredentials(true) ile birlikte kullan
        config.setAllowedHeaders(List.of("*")); // Tüm header'lara izin verir
        config.setAllowedMethods(List.of("*")); // Tüm HTTP metodlarına izin verir
        
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}