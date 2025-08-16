package com.dam.ApiRestMultiTabla.authors.domain.exceptions;

public class AuthorByCountryNotFoundException extends RuntimeException {
    public AuthorByCountryNotFoundException(String pais) {
        super("No existen autores para el pais " + pais);
    }
}
