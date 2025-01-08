package com.example.ejercicio_once.controller;


import com.example.ejercicio_once.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private Usuario usuario;


    @GetMapping("/usuarios")
    public String obtenerUsuario(@RequestParam(required = false) String filtro, Model model) {

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1, "Juan", "juan@es.es"));
        usuarios.add(new Usuario(2, "Silvia", "silvia@es.es"));

        List<Usuario> usuariosFiltrados = new ArrayList<>();
        List<Usuario> usuariosEncontrados = new ArrayList<>();

        usuarios.forEach( usuario -> {
            if(usuario.getNombre().equalsIgnoreCase(filtro) || usuario.getEmail().equalsIgnoreCase(filtro)){
                System.out.println("Usuario encontrado");
                usuariosEncontrados.add(usuario);
            }
        });

        if(!usuariosEncontrados.isEmpty()){
            model.addAttribute("usuarios" , usuariosEncontrados);
        }else{
            model.addAttribute("notFound" , "El usuario no existe");
        }




        return "usuarios";

    }




}
