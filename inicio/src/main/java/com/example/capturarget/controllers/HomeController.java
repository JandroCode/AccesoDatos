package com.example.capturarget.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomeController {


    @GetMapping("/uno")
    public String obtenerUno(){
        return "unoVista";
    }

    @GetMapping("/dos")
    public String obtenerDos(){
        return "dosVista";
    }

    @GetMapping("/tres")
    public String obtenerTres(){
        return "vistas/tresVista";
    }


    
    
}
