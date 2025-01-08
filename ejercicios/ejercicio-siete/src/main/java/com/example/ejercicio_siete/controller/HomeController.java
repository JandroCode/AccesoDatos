package com.example.ejercicio_siete.controller;

import com.example.ejercicio_siete.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {


    @GetMapping("/form")
    public String getForm(Model model){
        model.addAttribute("usuario" , new Usuario());
        return "form";
    }


    @PostMapping("/form")
    public String postForm(@Valid Usuario usuario,
                           BindingResult result ,
                           @RequestParam(required = false) String nombre,
                           @RequestParam(required = false)Integer edad,
                           Model model) {


        if(result.hasErrors()){

            return "form";
        }

        model.addAttribute("nombre" , nombre);
        model.addAttribute("edad" , edad);


        return "form";
    }



}
