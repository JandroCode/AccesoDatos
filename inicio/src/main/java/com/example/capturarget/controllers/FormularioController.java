package com.example.capturarget.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormularioController {

    @GetMapping("/form")
    public String form(){
        return "form";
    }

    @GetMapping("/get-form")
    public String obtenerDatos(@RequestParam String username, @RequestParam String email , Model model){
        model.addAttribute("username", username);
        model.addAttribute("email", email);

        return "datos";
    }


    @PostMapping("/post-form")
    public String obtenerDatosPorPost(@RequestParam String username, @RequestParam String email , Model model){
        model.addAttribute("username", username);
        model.addAttribute("email", email);

        return "datos";
    }
    
}
