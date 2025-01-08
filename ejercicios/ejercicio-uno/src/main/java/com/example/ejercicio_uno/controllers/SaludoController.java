package com.example.ejercicio_uno.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SaludoController {

    @GetMapping
    public String getSaludo(Model model){
        model.addAttribute("saludo" , "Hola qué tal !!");
        return "saludo";
    }
}
