package com.example.ejercicio_cuatro.model;

public class Usuario {

    private String username;
    private String email;
    private  Integer edad;

    public Usuario() {
    }

    public Usuario(String username, String email, Integer edad) {
        this.username = username;
        this.email = email;
        this.edad = edad;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
