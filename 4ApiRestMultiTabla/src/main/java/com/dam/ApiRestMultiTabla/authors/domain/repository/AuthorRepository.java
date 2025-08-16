package com.dam.ApiRestMultiTabla.authors.domain.repository;

import com.dam.ApiRestMultiTabla.authors.domain.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    // Buscar autor por nombre (Query Methods)
    List<Author> findByNameContainingIgnoreCase(String name);


    // Buscar autor por nacionalidad (JPQL)
    @Query("SELECT a FROM Author a WHERE LOWER(a.nationality) = LOWER(:nationality)")
    List<Author> findByNationalityIgnoreCase(@Param("nationality")String nationality);

    // Devuelve todos los autores, Spring Data ordenará según el tamaño de la colección books
    @Query(value = """
       SELECT a.*, COUNT(b.id) as book_count
       FROM authors a
       LEFT JOIN books b ON a.id = b.author_id
       GROUP BY a.id
       ORDER BY book_count DESC, a.name ASC
       """,
            nativeQuery = true)
    Page<Author> findAllAuthorsOrderByBookCount(Pageable pageable);
}
