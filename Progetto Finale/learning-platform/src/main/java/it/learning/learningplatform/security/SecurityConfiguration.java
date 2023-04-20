package it.learning.learningplatform.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Bean
    public SecurityFilterChain configSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
            .authorizeHttpRequests()
            .anyRequest().permitAll();

        return http.build();
    }

}
