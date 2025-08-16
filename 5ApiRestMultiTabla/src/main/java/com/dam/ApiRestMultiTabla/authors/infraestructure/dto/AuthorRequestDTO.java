package com.dam.ApiRestMultiTabla.authors.infraestructure.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthorRequestDTO {
    @NotBlank(message = "El nombre es requerido")
    @Size(max = 100, message = "El nombre debe tener menos de 100 caracteres")
    private String name;

    @NotBlank(message = "La nacionalidad es requerida")
    @Size(max = 50, message = "La nacionalidad debe tener menos de 50 caracteres")
    private String nationality;

}
