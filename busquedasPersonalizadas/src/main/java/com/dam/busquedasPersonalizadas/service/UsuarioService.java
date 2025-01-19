package com.dam.busquedasPersonalizadas.service;

import com.dam.busquedasPersonalizadas.model.Usuario;
import com.dam.busquedasPersonalizadas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Buscar por Id
    public Usuario buscar(Long id){
        return  usuarioRepository.findById(id).orElse(null);
    }

    // Buscar por Username
    public Usuario buscarPorUsername(String username){
        return  usuarioRepository.findByUsername(username);
    }

    // Buscar por Email
    public Usuario buscarPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    // Buscar por Edad
    public Usuario buscarPorEdad(Integer edad){
        return usuarioRepository.findByEdad(edad);
    }

    // Buscar por Edad Mayor de un parámetro
    public List<Usuario> buscarPorEdadMayorDe(Integer edad){
        return usuarioRepository.findByEdadGreaterThan(edad);
    }


}
