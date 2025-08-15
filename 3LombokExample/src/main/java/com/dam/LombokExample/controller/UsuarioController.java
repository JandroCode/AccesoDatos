package com.dam.LombokExample.controller;

import com.dam.LombokExample.models.Usuario;
import com.dam.LombokExample.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> lista(){
        return usuarioService.obtenerUsuarios();
    }



}
