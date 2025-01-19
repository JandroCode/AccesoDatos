package com.dam.busquedasPersonalizadas.repository;

import com.dam.busquedasPersonalizadas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByUsername(String username);
    Usuario findByEdad(Integer edad);
    Usuario findByEmail(String email);
    List<Usuario> findByEdadGreaterThan(Integer edad);
}
