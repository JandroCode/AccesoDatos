package com.dam.busquedasPersonalizadas.controller;

import com.dam.busquedasPersonalizadas.model.Usuario;
import com.dam.busquedasPersonalizadas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/{id}")
    public String buscar(@PathVariable Long id , Model model){
        Usuario usuario = usuarioService.buscar(id);

        if(usuario != null){
            model.addAttribute("usuario" , usuario);
            return "usuarioView";
        }

        return "404";
    }

    @GetMapping("/por-email/{email}")
    public String buscarPorEmail(@PathVariable String email , Model model){
        Usuario usuario = usuarioService.buscarPorEmail(email);

        if(usuario != null){
            model.addAttribute("usuario" , usuario);
            return "usuarioView";
        }

        return "404";
    }

    @GetMapping("/por-edad/{edad}")
    public String buscarPorEdad(@PathVariable Integer edad , Model model){
        Usuario usuario = usuarioService.buscarPorEdad(edad);

        if(usuario != null){
            model.addAttribute("usuario" , usuario);
            return "usuarioView";
        }

        return "404";
    }

    @GetMapping("/por-edad-mayor-de/{edad}")
    public String buscarPorEdadMayorDe(@PathVariable Integer edad , Model model){
        List<Usuario> usuarios = usuarioService.buscarPorEdadMayorDe(edad);

        if(!usuarios.isEmpty()){
            model.addAttribute("usuarios" , usuarios);
            return "usuariosView";
        }

        return "404";
    }



}
