package com.dam.ApiRestMultiTabla.books.domain.repository;

import com.dam.ApiRestMultiTabla.books.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
