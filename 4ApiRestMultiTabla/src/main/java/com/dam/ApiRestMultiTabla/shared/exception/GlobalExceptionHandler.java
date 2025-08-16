package com.dam.ApiRestMultiTabla.shared.exception;


import com.dam.ApiRestMultiTabla.authors.domain.exceptions.AuthorByCountryNotFoundException;
import com.dam.ApiRestMultiTabla.authors.domain.exceptions.AuthorNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.net.PortUnreachableException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleAuthorNotFound(AuthorNotFoundException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put("id" , ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }

    @ExceptionHandler(AuthorByCountryNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleAuthorByCountryNotFoundException(AuthorByCountryNotFoundException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put("pais" , ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(
            jakarta.validation.ConstraintViolationException ex) {

        Map<String, String> errors = new HashMap<>();
        // Recorremos todas las violaciones de constraints
        ex.getConstraintViolations().forEach(violation ->
                // Agregamos al mapa la ruta de la propiedad y el mensaje de error
                errors.put(violation.getPropertyPath().toString(), violation.getMessage())
        );

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(PageNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlePageNotFound(PageNotFoundException ex) {
        Map<String, Object> errorBody = new HashMap<>();

        errorBody.put("message", ex.getMessage());

        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(NoHandlerFoundException ex) {
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("status", HttpStatus.NOT_FOUND.value());
        errorBody.put("error", "URL no encontrada");
        errorBody.put("message", "La URL '" + ex.getRequestURL() + "' no existe en el servidor");

        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }




}
