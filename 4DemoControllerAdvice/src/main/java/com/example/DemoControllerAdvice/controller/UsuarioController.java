package com.example.DemoControllerAdvice.controller;

import com.example.DemoControllerAdvice.dto.UsuarioDTO;
import com.example.DemoControllerAdvice.exceptions.UsuarioNoEncontradoException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {


    @GetMapping("/{id}")
    public String getUsuario(@PathVariable Long id){

        if(id <= 0){
            throw  new UsuarioNoEncontradoException("Usuario no encontrado con id " + id);
        }

        return  "Usuario " + id;
    }

    @PostMapping
    public String crearUsuario(@Valid @RequestBody UsuarioDTO usuario){
        return "Usuario creado : " + usuario.getNombre() + " Edad :" + usuario.getEdad();
    }


}
