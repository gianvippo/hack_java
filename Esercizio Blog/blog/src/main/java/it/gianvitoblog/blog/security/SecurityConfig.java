package it.gianvitoblog.blog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager createUserDetails() {

        String password = passwordEncoder().encode("password");

        UserBuilder userBuilder = User.withUsername("user")
                .password(password)
                .roles("USER");

        UserBuilder adminBuilder = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("USER", "ADMIN");

        return new InMemoryUserDetailsManager(userBuilder.build(), adminBuilder.build());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/login", "/logout", "/api/**").permitAll()
                .requestMatchers("/authors/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
            .and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login") // POST
                .defaultSuccessUrl("/", true) // specifichiamo il redirect di default, con true fa sempre quel redirect
            .and().logout()
                .logoutUrl("/logout")  // POST
                .logoutSuccessUrl("/login")
            .and() .csrf().ignoringRequestMatchers("api/**")
                .and().headers()
                .xssProtection()
                .and().contentSecurityPolicy(
                        "style-src 'self' maxcdn.bootstrapcdn.com getbootstrap.com *.googleapis.com cdn.jsdelivr.net cdnjs.cloudflare.com; script-src 'self' cdn.jsdelivr.net");

        return http.build();
    }

}
