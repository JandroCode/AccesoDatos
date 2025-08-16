package com.dam.ApiRestMultiTabla.authors.infraestructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorSimpleDTO {
    private Long id;
    private String name;
    private String nationality;
}
