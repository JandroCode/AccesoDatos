package com.dam.ApiRestMultiTabla.books.application;

import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorSimpleDTO;
import com.dam.ApiRestMultiTabla.books.domain.model.Book;
import com.dam.ApiRestMultiTabla.books.domain.repository.BookRepository;
import com.dam.ApiRestMultiTabla.books.infraestructure.dto.BookResponseDTO;
import com.dam.ApiRestMultiTabla.books.infraestructure.dto.BookSimpleDTO;
import com.dam.ApiRestMultiTabla.books.infraestructure.mapper.BookMapper;
import com.dam.ApiRestMultiTabla.shared.dto.PagedResponseDTO;
import com.dam.ApiRestMultiTabla.shared.exception.PageNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper){
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }


    @Override
    public Page<BookResponseDTO> getAllBooks(Pageable pageable) {
        Page<Book> booksPage = bookRepository.findAll(pageable);

        if (pageable.getPageNumber() >= 0) {
            throw new PageNotFoundException(pageable.getPageNumber() + 1);
        }

        return booksPage.map(book -> {
            // Map author to simple DTO if exists
            AuthorSimpleDTO authorDto = null;
            if (book.getAuthor() != null) {
                authorDto = new AuthorSimpleDTO(
                        book.getAuthor().getId(),
                        book.getAuthor().getName(),
                        book.getAuthor().getNationality()
                );
            }


            return BookResponseDTO.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .publicationYear(book.getPublicationYear())
                    .genre(book.getGenre().getDisplayName())
                    .author(authorDto)
                    .build();
        });
    }
}