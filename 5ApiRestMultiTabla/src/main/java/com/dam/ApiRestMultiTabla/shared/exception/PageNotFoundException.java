package com.dam.ApiRestMultiTabla.shared.exception;


import lombok.Getter;

@Getter
public class PageNotFoundException extends RuntimeException {
    private final int page;

    public PageNotFoundException(int page) {
        super("La página " + page + " no existe");
        this.page = page;
    }

}
