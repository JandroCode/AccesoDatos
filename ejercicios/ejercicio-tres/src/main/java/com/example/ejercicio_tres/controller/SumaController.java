package com.example.ejercicio_tres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SumaController {


    @GetMapping
    public String form(){
        return "form";
    }

    @PostMapping("/suma")
    public String sumar(@RequestParam int num1, @RequestParam int num2, Model model){
        int suma = num1 + num2;
        model.addAttribute("suma" , suma);

        return "suma";
    }


}
