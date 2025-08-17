package com.example.DocumentacionApi.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuarios")
@Tag(name = "Usuarios" , description = "Operaciones sobre usuarios")
public class UsuarioController {


    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuario por id", description = "Retorna el usuario correspondiente al parámetro de la URL")
    public String getUsuario(@PathVariable Long id){
        return "Usuario " + id;
    }

    public String crearUsuario(@RequestBody Object o){
        return "Usuario creado";

    }
}
