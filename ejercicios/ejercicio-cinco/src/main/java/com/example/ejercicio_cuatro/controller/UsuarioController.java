package com.example.ejercicio_cuatro.controller;

import com.example.ejercicio_cuatro.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {

    @GetMapping
    public String obtenerUsuarios(Model model){

        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuarioUno = new Usuario("Pepe" , "pepe@es.es" , 32);
        Usuario usuarioDos = new Usuario("Luisa" , "luisaes.es" , 56);

        usuarios.add(usuarioUno);
        usuarios.add(usuarioDos);

        usuarios.add(new Usuario("Emiio" , "emilio@es.es" , 54));

        model.addAttribute("usuarios" , usuarios);

        return "usuarios";

    }

    @GetMapping("/obtener-parametros")
    public String obtenerParametros(@RequestParam(required = false)String username,
                                    @RequestParam(required = false) String email,
                                    @RequestParam(required = false) Integer edad,
                                    Model model){
        model.addAttribute("username" , username);
        model.addAttribute("email" , email);
        model.addAttribute("edad" , edad);

        return "datos";


    }





}
