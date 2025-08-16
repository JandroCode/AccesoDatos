package com.dam.ApiRestMultiTabla.authors.infraestructure.mapper;

import com.dam.ApiRestMultiTabla.authors.domain.model.Author;
import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorRequestDTO;
import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorResponseDTO;
import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorSimpleDTO;
import com.dam.ApiRestMultiTabla.authors.infraestructure.dto.AuthorWihBooksRequestDTO;
import com.dam.ApiRestMultiTabla.books.domain.model.Book;
import com.dam.ApiRestMultiTabla.books.infraestructure.dto.BookSimpleDTO;
import com.dam.ApiRestMultiTabla.books.infraestructure.mapper.BookMapper;
import jdk.jfr.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorMapper {

    private final BookMapper bookMapper;


    public  AuthorMapper(@Lazy  BookMapper bookMapper){
        this.bookMapper = bookMapper;
    }

    public Author toEntity(AuthorRequestDTO dto){
        if(dto == null) return null;

        return Author.builder()
                .name(dto.getName())
                .nationality(dto.getNationality())
                .build();
    }

    public AuthorResponseDTO toDto(Author author){
        if(author == null) return  null;

        List<BookSimpleDTO> booksDto = author.getBooks() != null ?
                author.getBooks().stream().map(bookMapper::toSimpleDto)
                        .collect(Collectors.toList()) : null;

        return AuthorResponseDTO.builder()
                .id(author.getId())
                .name(author.getName())
                .nationality(author.getNationality())
                .books(booksDto)
                .build();
    }

    public AuthorSimpleDTO toEntityWithBooks(AuthorWihBooksRequestDTO dto){
        // Crear entidad Author
        Author author = Author.builder()
                .name(dto.getName())
                .nationality(dto.getNationality())
                .build();

        // Agregar libros si existen
        if(dto.getBooks() != null){
            dto.getBooks().forEach(bookDto ->{
                Book book = bookMapper.toEntity(bookDto);
                author.addBook(book);  // asegura la relación bidireccional
            });
        }

        // Convertir a DTO simple para la respuesta
        return AuthorSimpleDTO.builder()
                .id(author.getId())
                .name(author.getName())
                .nationality(author.getNationality())
                .build();
    }



    public AuthorSimpleDTO toSimpleDto(Author author){
        if(author == null) return null;

        return AuthorSimpleDTO.builder()
                .id(author.getId())
                .name(author.getName())
                .nationality(author.getNationality())
                .build();
    }




}
