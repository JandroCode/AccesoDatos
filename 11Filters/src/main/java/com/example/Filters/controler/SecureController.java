package com.example.Filters.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class SecureController {

    private static final Logger LOG = LoggerFactory.getLogger(SecureController.class);

    @GetMapping("/secure")
    public Map<String, String> secureEndpoint(){
        LOG.info("Acceso concedido al endpoint seguro");
        return  Map.of("message", "Acceso concedido a recurso seguro" );
    }

    @GetMapping("/home")
    public Map<String, String> publicEndpoint(){
        LOG.info("Acceso a endpoint público");
        return  Map.of("message", "Acceso público" );
    }
}
