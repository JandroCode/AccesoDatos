package com.dam.busquedasPersonalizadas.repository;

import com.dam.busquedasPersonalizadas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    // QUERY METHODS
    Usuario findByUsername(String username);
    Usuario findByEdad(Integer edad);
    Usuario findByEmail(String email);
    List<Usuario> findByEdadGreaterThan(Integer edad);


    // CONSULTAS NATIVAS (NATIVE QUERIES)
    @Query(value = "SELECT * FROM usuarios" , nativeQuery = true)
    List<Usuario> listaUsuarios();

    @Query(value = "SELECT * FROM usuarios WHERE username = :username" , nativeQuery = true)
    Usuario buscarUsuarioNative(String username);

    // Consultas con JPQL
    @Query(value = "SELECT u FROM Usuario u WHERE edad = :edad")
    Usuario buscarPorEdadJpql(Integer edad);

}
