package com.example.Filters.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class ApiAuthFilter  implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(ApiAuthFilter.class);

    private static final String AUTH_USER = "pepe";
    private static final String AUTH_PASS = "1234";
    private static final String SECURE_ENDPOINT = "/api/secure";


    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Si la URL del endpoint coincide con nuestra URL securizada
        if (SECURE_ENDPOINT.equals(httpRequest.getRequestURI())){

            // Obtener las credenciales de las cabeceras http
            String username = httpRequest.getHeader("username");
            String password = httpRequest.getHeader("password");

            LOG.info("Usuario de la cabecera " + username);
            LOG.info("Contraseña de la cabecera " + password);

            LOG.info("Intento de acceso a {} - Usuario {}" , SECURE_ENDPOINT, username);
            LOG.info("Detalles de la solicitud http: Método  {} , IP = {}" , httpRequest.getMethod(), httpRequest.getRemoteAddr());

            if(!AUTH_USER.equals(username) || !AUTH_PASS.equals(password)){
                LOG.warn("Intento de acceso fallido - Usuario {}" , username);
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

                // Para visualizarlo en el body del cliente (POSTMAN , ...)
                httpResponse.getWriter().write("Credenciales incorrectas");
                return;
            }

            LOG.info("Acceso autorizado para {}", username);
        }

        filterChain.doFilter(request, response);
    }
}
