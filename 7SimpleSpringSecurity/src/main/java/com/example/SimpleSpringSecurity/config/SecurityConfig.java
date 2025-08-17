package com.example.SimpleSpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Definimos el usuario en memoria
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user  = User
                .withUsername("Pepe")
                .password("{noop}1234")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    // Configuración de la seguridad
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers("/home").authenticated() //Proteger "/home"
                        .anyRequest().permitAll()  // el resto accesible

                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll() //true le dice si debe ignorar la página a la que el usuario intentaba ir antes del login y redirigir siempre a /home después de iniciar sesión.
                )
                .logout(logout -> logout.permitAll());

        return http.build();



    }
}
