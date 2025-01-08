package com.example.capturarget.controllers.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class Persona {

    private Integer id;

    @NotBlank(message = "El campo nombre es obligatorio")
    private String nombre;


    @NotBlank(message = "El campo nombre es obligatorio")
    @Email(message = "El formato de email es incorreto")
    private String email;

    public Persona() {
    }

    public Persona(Integer id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    

    






    
}
