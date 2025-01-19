package com.example.ejercicio1.controller;

import com.example.ejercicio1.model.Usuario;
import com.example.ejercicio1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String form(){
        return "form";
    }


    @PostMapping("/buscar")
    public String buscar(@RequestParam(required = false) String username , Model model){
        Usuario usuario = usuarioService.buscarUsuario(username);

        if(usuario != null){
            model.addAttribute("usuario" , usuario);
            return "detallesUsuario";
        }

        return "404";
    }


}
