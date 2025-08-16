package com.dam.ApiRestMultiTabla.books.application;

import com.dam.ApiRestMultiTabla.books.infraestructure.dto.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<BookResponseDTO> getAllBooks(Pageable pageable);
}
