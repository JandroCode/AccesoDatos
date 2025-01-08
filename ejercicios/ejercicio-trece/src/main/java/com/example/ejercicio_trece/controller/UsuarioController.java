package com.example.ejercicio_trece.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UsuarioController {

    @GetMapping("/")
    public String form(){
        return "form";
    }

    @PostMapping("/post")
    public String postForm(@RequestParam String nombre,
                           @RequestParam String email,
                           @RequestParam String password, Model model){

        model.addAttribute("nombre" , nombre);
        model.addAttribute("email" , email);


        return "confirmacion";
    }







}
