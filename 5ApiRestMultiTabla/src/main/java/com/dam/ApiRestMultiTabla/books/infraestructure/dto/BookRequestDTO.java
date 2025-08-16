package com.dam.ApiRestMultiTabla.books.infraestructure.dto;

import com.dam.ApiRestMultiTabla.books.domain.model.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;


@Data
public class BookRequestDTO {

    @NotBlank(message = "El título es requerido")
    @Size(max = 200, message = "El título debe tener menos de 200 caracteres")
    private String title;

    @NotNull(message = "El año de publicación es requerido")
    private Integer publicationYear;

    @NotNull(message = "El género es requerido")
    private Genre genre;

    @NotNull(message = "El ID del autor es requerido")
    private Long authorId;
}
