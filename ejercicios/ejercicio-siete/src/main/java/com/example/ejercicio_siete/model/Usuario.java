package com.example.ejercicio_siete.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Usuario {


    @NotEmpty(message = "El campo nombre no puede estar vacío")
    private String nombre;


    @NotNull(message = "El campo edad no puede estar vacío")
    @Min(value = 18, message = "La edad debe ser al menos 18.")
    private  Integer edad;

    public Usuario(){}

    public Usuario(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }


    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
