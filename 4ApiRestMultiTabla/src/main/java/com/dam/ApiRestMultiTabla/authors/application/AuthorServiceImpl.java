package com.dam.ApiRestMultiTabla.authors.application;


import com.dam.ApiRestMultiTabla.authors.domain.exceptions.AuthorByCountryNotFoundException;
import com.dam.ApiRestMultiTabla.authors.domain.exceptions.AuthorNotFoundException;
import com.dam.ApiRestMultiTabla.authors.domain.model.Author;
import com.dam.ApiRestMultiTabla.authors.domain.repository.AuthorRepository;
import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorRequestDTO;
import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorResponseDTO;
import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorSimpleDTO;
import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorWihBooksRequestDTO;
import com.dam.ApiRestMultiTabla.authors.infraestructure.mapper.AuthorMapper;
import com.dam.ApiRestMultiTabla.books.domain.model.Book;
import com.dam.ApiRestMultiTabla.books.infraestructure.dto.BookRequestDTO;
import com.dam.ApiRestMultiTabla.books.infraestructure.dto.BookResponseDTO;
import com.dam.ApiRestMultiTabla.books.infraestructure.mapper.BookMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private final BookMapper bookMapper;


    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper, BookMapper bookMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
        this.bookMapper = bookMapper;
    }


    @Override
    public AuthorSimpleDTO createAuthor(AuthorRequestDTO authorRequestDTO) {
        if(authorRequestDTO == null) throw  new IllegalArgumentException("Los datos del autor no pueden ser nulos");

        Author author = authorMapper.toEntity(authorRequestDTO);
        Author savedAuthor = authorRepository.save(author);

        return authorMapper.toSimpleDto(savedAuthor);
    }

    @Override
    public AuthorResponseDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));

        return authorMapper.toDto(author);
    }

    @Override
    public AuthorSimpleDTO createAuthorWithBooks(AuthorWihBooksRequestDTO authorWihBooksRequestDTO) {
        if (authorWihBooksRequestDTO == null) return null;

        Author author =Author.builder()
                .name(authorWihBooksRequestDTO.getName())
                .nationality(authorWihBooksRequestDTO.getNationality())
                .build();

        // Agregar libros si existen
        if(authorWihBooksRequestDTO.getBooks() != null){
            authorWihBooksRequestDTO.getBooks().forEach(bookDto ->{
                Book book = bookMapper.toEntity(bookDto);
                author.addBook(book);
            });
        }

        // Guardar en la base de datos
        Author savedAuthor = authorRepository.save(author);

        // Convertir a DTO de respuesta
        return authorMapper.toSimpleDto(savedAuthor);
    }

    @Override
    public AuthorResponseDTO addBooksToAuthor(Long authorId, List<BookRequestDTO> books) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        if (books != null && !books.isEmpty()) {
            books.forEach(bookDto -> {
                Book book = bookMapper.toEntity(bookDto);
                author.addBook(book);
            });
        }

        Author updatedAuthor = authorRepository.save(author);
        return authorMapper.toDto(updatedAuthor);
    }


    @Override
    public List<AuthorSimpleDTO> getAuthorsByNationality(String nationality) {
        List<Author> authors = authorRepository.findByNationalityIgnoreCase(nationality);
        if (authors.isEmpty()) {
            throw new AuthorByCountryNotFoundException("No se encontraron autores del país: " + nationality);
        }

        return authors.stream().map(authorMapper::toSimpleDto).toList();
    }

    @Override
    public Page<AuthorSimpleDTO> getAuthorsOrderByBookCount(Pageable pageable) {
        Page<Author> authorsPage = authorRepository.findAllAuthorsOrderByBookCount(pageable);
        return authorsPage.map(authorMapper::toSimpleDto);
    }

}

