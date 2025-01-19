package com.example.ejercicio1.service;

import com.example.ejercicio1.model.Usuario;
import com.example.ejercicio1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;



    public Usuario buscarUsuario(String username){
        return usuarioRepository.findByUsername(username);
    }



}
