package com.example.ejercicio_catorce.controller;

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
    public String suma(@RequestParam Integer numero1,@RequestParam Integer numero2 , Model model){
        int suma = numero1 + numero2;
        model.addAttribute("numero1" , numero1);
        model.addAttribute("numero2" , numero2);
        model.addAttribute("suma" , suma);
        return "resultado";
    }









}
