package com.dam.ApiRestMultiTabla.books.infraestructure.web;

import com.dam.ApiRestMultiTabla.books.application.BookService;
import com.dam.ApiRestMultiTabla.books.infraestructure.dto.BookResponseDTO;
import com.dam.ApiRestMultiTabla.books.infraestructure.dto.BookSimpleDTO;
import com.dam.ApiRestMultiTabla.shared.dto.PagedResponseDTO;
import com.dam.ApiRestMultiTabla.shared.exception.PageNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService  bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }


    @GetMapping("/page/{page}")
    public ResponseEntity<PagedResponseDTO<BookResponseDTO>> listBooksPaginated(
            @PathVariable int page
    ) {

        if (page <= 0) {
            throw new PageNotFoundException(page);
        }

        Pageable pageable = PageRequest.of(page - 1, 5); // Spring Data es 0-indexed

        Page<BookResponseDTO> pageResult = bookService.getAllBooks(pageable);

        PagedResponseDTO<BookResponseDTO> response = new PagedResponseDTO<>();
        response.setContent(pageResult.getContent());
        response.setPage(pageResult.getNumber() + 1); // opcional, para que sea 1-indexed
        response.setSize(pageResult.getSize());
        response.setTotalElements(pageResult.getTotalElements());
        response.setTotalPages(pageResult.getTotalPages());

        return ResponseEntity.ok(response);
    }


}
