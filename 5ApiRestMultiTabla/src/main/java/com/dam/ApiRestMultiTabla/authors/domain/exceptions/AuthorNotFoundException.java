package com.dam.ApiRestMultiTabla.authors.domain.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id) {
        super("El autor con id " + id + " no existe");
    }
}
