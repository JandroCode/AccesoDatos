package com.dam.ApiRestMultiTabla.books.infraestructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class BookSimpleDTO {
    private Long id;
    private String title;
    private Integer publicationYear;
    private String genre;
}
