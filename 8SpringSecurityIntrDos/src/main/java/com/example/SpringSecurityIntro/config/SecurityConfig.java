package com.example.SpringSecurityIntro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {


    // Definir el usuario autenticado (en memoria, en base de datos, ...)
    // Defino un usuario válido en memoria
    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails pepe = User
                .withUsername("pepe")
                .password("{noop}1234")
                .roles("USER").build();

        UserDetails marta = User
                .withUsername("marta")
                .password("{noop}1234")
                .roles("ADMIN").build();

        UserDetails luis = User
                .withUsername("luis")
                .password("{noop}1234")
                .roles("GESTOR").build();

        UserDetails vendedor = User
                .withUsername("vendedor")
                .password("{noop}1234")
                .roles("VENDEDOR").build();

        return new InMemoryUserDetailsManager(pepe,marta,luis,vendedor);
    }



    // Configuración de la seguridad

    /*

        @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(auth -> auth

                        .requestMatchers("/home").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()

                )
                .logout(logout -> logout.permitAll());

        return http.build();

    }



     */



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(auth -> auth

                        .requestMatchers("/home")
                                .authenticated()  // Proteger "/home"
                        .anyRequest().permitAll() // El resto de URLs accesibles
                            )
                            .formLogin(form -> form
                                    .loginPage("/login")
                                    .defaultSuccessUrl("/home", true)
                                    .permitAll()

                            )
                .logout(logout -> logout.permitAll())
                .exceptionHandling( ex -> ex.accessDeniedPage("/error403"));

        return http.build();

    }
}
