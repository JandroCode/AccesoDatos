package com.example.capturarget.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/obtener-get")
public class ObtenerParametrosGetController {


    @GetMapping("/query-params")
    public String obtenerQueryString(@RequestParam(name = "id", required = false) Integer id,
                                    @RequestParam(name = "email", required = false) 
                                    String email, Model model){
        model.addAttribute("usuarioId", id);
        model.addAttribute("email", email);
        System.out.println("ID:" + id);
        return "obtenerQueryStringVista";
    }

    @GetMapping("/path-variable/{id}")
    public String obtenerPathVaraible(@PathVariable(name = "id") Long identificador, Model model){
        model.addAttribute("usuarioId", identificador);
        System.out.println("ID:" + identificador);
        return "obtenerPathVariableVista";
    }
    
}
