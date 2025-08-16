package com.dam.ApiRestMultiTabla.books.infraestructure.dto;

import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorSimpleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
public class BookResponseDTO {
    private Long id;
    private String title;
    private Integer publicationYear;
    private String genre;
    private AuthorSimpleDTO author;
}
