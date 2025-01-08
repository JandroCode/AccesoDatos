package com.example.capturarget.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.capturarget.controllers.model.Persona;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/validaciones")
public class ValifacionesController {


    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("persona", new Persona());
        return "validaciones/form";
    }

    @PostMapping("/post")
    public String guardar(@Valid Persona persona, BindingResult result){
        if(result.hasErrors()){
            return "validaciones/form";
        }else{
            return "validaciones/datos";
        }
        
    }
    
    
}
