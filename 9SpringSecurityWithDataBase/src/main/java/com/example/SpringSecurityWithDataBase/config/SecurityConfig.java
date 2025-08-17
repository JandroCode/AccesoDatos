package com.example.SpringSecurityWithDataBase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/home").hasAnyRole("USER" , "ADMIN", "GESTOR")
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/gestor").hasRole("GESTOR")
                .anyRequest().permitAll()
        )
                .formLogin(form -> form
                        .loginPage("/login")
                                .defaultSuccessUrl("/home", true)
                                .permitAll()
                        )
                .logout(logout ->logout.permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
