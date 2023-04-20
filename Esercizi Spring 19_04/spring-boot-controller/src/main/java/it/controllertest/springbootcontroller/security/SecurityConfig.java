package it.controllertest.springbootcontroller.security;

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

    /*
     * 
     * org.springframework.security.provisioning.JdbcUserDetailsManager
     * - gestisco direttamente le query a database per creare e recuperare gli
     * utenti
     * 
     * org.springframework.security.core.userdetails.UserDetailsService
     * - interfaccia service che mi permette di fare injection del mio repository
     * e gestire creazione, eliminazione, aggiornamento e recupero degli utenti
     * 
     * org.springframework.security.provisioning.InMemoryUserDetailsManager
     * - costruisco ad-hoc gli utenti in memoria con di base username e password
     * 
     */

    //
    // SHA-256 - algoritmo di encoding / generazione firma / digest
    // password -> SHA-256 ->
    // 5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8
    // BCrypt - algoritmo di encoding / generazione firma / digest (base64)
    // password -> BCrypt -> $2a $10
    // $rL6IXNgaXHKpfvtNE99Zse3631gpobBvCAo/d6etOWfnNV9FCYg5m

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
