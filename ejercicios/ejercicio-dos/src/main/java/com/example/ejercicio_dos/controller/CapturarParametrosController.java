package com.example.ejercicio_dos.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CapturarParametrosController {


    @GetMapping("/calcular-edad")
    public String obtenerDatos(@RequestParam String nombre, @RequestParam int edad , Model model){
        model.addAttribute("nombre", nombre);
        model.addAttribute("edad", edad);

        return "datos";
    }




}
