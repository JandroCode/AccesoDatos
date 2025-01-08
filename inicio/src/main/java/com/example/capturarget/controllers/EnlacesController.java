package com.example.capturarget.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/enlaces")
public class EnlacesController {


    @GetMapping
    public String home(){
        return "enlaces";
    }

    @GetMapping("/obtener-datos")
    public String obtenerDatos(@RequestParam Integer id, Model model){
        model.addAttribute("idUsuario", id);
        return "datosEnlaces";
    }

    
    @GetMapping("/path-variable/{id}")
    public String obtenerDatosPorPathVariable(@PathVariable Integer id, Model model){
        model.addAttribute("idUsuario", id);
        return "datosEnlaces";
    }
    
}
