package com.example.ejercicio_ocho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/saludo")
    public String saludo(@RequestParam(required = false) String nombre, Model model){
        model.addAttribute("nombre" ,  nombre);

        return "saludo";

    }
}
