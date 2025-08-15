package com.dam.LombokExample.service;

import com.dam.LombokExample.models.Usuario;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioService {

    public List<Usuario> obtenerUsuarios(){
        return Arrays.asList(
                Usuario.builder()
                        .id(1L)
                        .username("Juan")
                        .build(),

                Usuario.builder()
                        .id(2L)
                        .username("Marta")
                        .build()

        );
    }
}
