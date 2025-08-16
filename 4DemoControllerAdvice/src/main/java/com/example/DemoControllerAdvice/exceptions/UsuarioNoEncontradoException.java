package com.example.DemoControllerAdvice.exceptions;

public class UsuarioNoEncontradoException extends RuntimeException{
    public UsuarioNoEncontradoException(String message) {
        super(message);
    }
}
