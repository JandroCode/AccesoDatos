package com.example.ejercicio_seis.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String username;
    private String email;


    public Usuario(){}


    public Usuario(String username, String email) {
        this.email = email;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Usuario> lista(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Luis" , "luis@es.es"));
        usuarios.add(new Usuario("Ana" , "ana@es.es"));

        return usuarios;
    }


}