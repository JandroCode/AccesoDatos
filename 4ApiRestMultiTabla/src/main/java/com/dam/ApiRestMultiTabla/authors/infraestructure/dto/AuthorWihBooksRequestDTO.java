package com.dam.ApiRestMultiTabla.authors.infraestructure.dto;

import com.dam.ApiRestMultiTabla.books.infraestructure.dto.BookRequestDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AuthorWihBooksRequestDTO {

    @NotBlank(message = "El nombre es requerido")
    @Size(max = 100, message = "El nombre debe tener menos de 100 caracteres")
    private String name;

    @Size(max = 50, message = "La nacionalidad debe tener menos de 50 caracteres")
    private String nationality;

    // Lista de libros asociados
    private List<BookRequestDTO> books;


}
