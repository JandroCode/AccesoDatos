package com.dam.ApiRestMultiTabla.authors.application;


import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorRequestDTO;
import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorResponseDTO;
import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorSimpleDTO;
import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorWihBooksRequestDTO;
import com.dam.ApiRestMultiTabla.books.domain.model.Book;
import com.dam.ApiRestMultiTabla.books.infraestructure.dto.BookRequestDTO;
import com.dam.ApiRestMultiTabla.books.infraestructure.dto.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface AuthorService {
    AuthorSimpleDTO createAuthor(AuthorRequestDTO authorRequestDTO);
    AuthorResponseDTO getAuthorById(Long id);
    AuthorSimpleDTO createAuthorWithBooks(AuthorWihBooksRequestDTO authorWihBooksRequestDTO);
    AuthorResponseDTO addBooksToAuthor(Long authorId, List<BookRequestDTO> books);

    List<AuthorSimpleDTO> getAuthorsByNationality(String nationality);
    Page<AuthorSimpleDTO> getAuthorsOrderByBookCount(Pageable pageable);
}
