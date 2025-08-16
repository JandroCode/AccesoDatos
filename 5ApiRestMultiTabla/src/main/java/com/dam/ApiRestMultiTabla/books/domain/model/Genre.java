package com.dam.ApiRestMultiTabla.books.domain.model;

public enum Genre {
    CIENCIA_FICCION("Ciencia ficción"),
    FANTASIA("Fantasía"),
    MISTERIO("Misterio"),
    SUSPENSO("Suspenso"),
    DRAMA("Drama");


    private final String displayName;

    Genre(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
