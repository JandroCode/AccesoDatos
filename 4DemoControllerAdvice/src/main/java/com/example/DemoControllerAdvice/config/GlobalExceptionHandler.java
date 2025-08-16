package com.example.DemoControllerAdvice.config;

import com.example.DemoControllerAdvice.exceptions.UsuarioNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handlesUsuarioNoEncontradoException(UsuarioNoEncontradoException ex){
        Map<String,String> response = new HashMap<>();
        response.put("error" , "Usuario no encontrado");
        response.put("mensajes" , ex.getMessage());
        response.put("codigo" , "404");

        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,Object> response = new HashMap<>();

        List<String> mensajes = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(err-> err.getField()+":"+err.getDefaultMessage())
                        .collect(Collectors.toList());


        response.put("error" , "Faltan datos del usuario");
        response.put("mensajes" , mensajes);

        return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}
