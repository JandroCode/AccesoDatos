package com.dam.ApiRestMultiTabla.books.infraestructure.mapper;

import com.dam.ApiRestMultiTabla.authors.infraestructure.mapper.AuthorMapper;
import com.dam.ApiRestMultiTabla.books.domain.model.Book;
import com.dam.ApiRestMultiTabla.books.infraestructure.dto.BookRequestDTO;
import com.dam.ApiRestMultiTabla.books.infraestructure.dto.BookResponseDTO;
import com.dam.ApiRestMultiTabla.books.infraestructure.dto.BookSimpleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    private final AuthorMapper authorMapper;

    public BookMapper(AuthorMapper authorMapper){
        this.authorMapper = authorMapper;
    }

    public Book toEntity(BookRequestDTO dto){
        if(dto == null) return null;

        return Book.builder()
                .title(dto.getTitle())
                .publicationYear(dto.getPublicationYear())
                .genre(dto.getGenre())
                .build();
    }

    public BookResponseDTO toDto(Book book){
        if(book == null) return null;

        return BookResponseDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .publicationYear(book.getPublicationYear())
                .genre(book.getGenre().getDisplayName())
                .build();
    }

    public BookSimpleDTO toSimpleDto(Book book){
        if(book == null) return null;

        return BookSimpleDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .publicationYear(book.getPublicationYear())
                .genre(book.getGenre().getDisplayName())
                .build();
    }

    public BookResponseDTO toDtoWihAuthor(Book book){
        if(book == null) return null;

        return BookResponseDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .publicationYear(book.getPublicationYear())
                .genre(book.getGenre().getDisplayName())
                .author(book.getAuthor() != null ? authorMapper.toSimpleDto(book.getAuthor()) : null)
                .build();
    }





}
