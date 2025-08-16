package com.dam.ApiRestMultiTabla.authors.infraestructure.dto;

import com.dam.ApiRestMultiTabla.books.infraestructure.dto.BookSimpleDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AuthorResponseDTO {
    private Long id;
    private String name;
    private String nationality;
    private List<BookSimpleDTO> books;

}
