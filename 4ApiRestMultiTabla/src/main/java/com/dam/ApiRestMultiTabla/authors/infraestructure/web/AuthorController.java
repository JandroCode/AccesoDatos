package com.dam.ApiRestMultiTabla.authors.infraestructure.web;


import com.dam.ApiRestMultiTabla.authors.application.AuthorService;
import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorRequestDTO;
import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorResponseDTO;
import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorSimpleDTO;
import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorWihBooksRequestDTO;
import com.dam.ApiRestMultiTabla.books.infraestructure.dto.BookRequestDTO;
import com.dam.ApiRestMultiTabla.shared.dto.PagedResponseDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    // Crear un autor sin libros
    @PostMapping
    public ResponseEntity<AuthorSimpleDTO> createAuthor(@RequestBody AuthorRequestDTO dto) {
        AuthorSimpleDTO saved = authorService.createAuthor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Crear un autor con libros
    @PostMapping("/with-books")
    public ResponseEntity<AuthorSimpleDTO> createAuthorWithBooks(
            @Valid @RequestBody AuthorWihBooksRequestDTO authorWithBooksRequestDTO) {
        AuthorSimpleDTO author = authorService.createAuthorWithBooks(authorWithBooksRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(author);
    }


    // Autores por id
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> getById(@PathVariable Long id){
        AuthorResponseDTO author= authorService.getAuthorById(id);
        return ResponseEntity.ok(author);
    }

    // Lista de autores por nacionalidad
    @GetMapping("/nationality/{nationality}")
    public ResponseEntity<List<AuthorSimpleDTO>> getAuthorsByNationality(@PathVariable String nationality) {
        List<AuthorSimpleDTO> authors = authorService.getAuthorsByNationality(nationality);
        return ResponseEntity.ok(authors);
    }

    // Lista ordenada de autores por número de ventas
    @GetMapping("/best-sellers/{page}/{size}")
    public ResponseEntity<PagedResponseDTO<AuthorSimpleDTO>> getAuthorsOrderedByBookCount(
            @PathVariable int page,
            @PathVariable int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<AuthorSimpleDTO> authorsPage = authorService.getAuthorsOrderByBookCount(pageable);

        PagedResponseDTO<AuthorSimpleDTO> response = new PagedResponseDTO<>(
                authorsPage.getContent(),
                authorsPage.getNumber() + 1, // devolver 1-based
                authorsPage.getSize(),
                authorsPage.getTotalElements(),
                authorsPage.getTotalPages()
        );

        return ResponseEntity.ok(response);
    }

    // Endpoint para añadir libros a un autor existente
    @PutMapping("/{id}/books")
    public ResponseEntity<AuthorResponseDTO> addBooksToAuthor(
            @PathVariable("id") Long authorId,
            @RequestBody List<BookRequestDTO> books) {

        AuthorResponseDTO updatedAuthor = authorService.addBooksToAuthor(authorId, books);
        return ResponseEntity.ok(updatedAuthor);
    }
}


