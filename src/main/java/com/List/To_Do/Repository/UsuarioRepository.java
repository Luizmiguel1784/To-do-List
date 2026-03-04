package com.List.To_Do.Repository;

import com.List.To_Do.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario>findByEmail(String email);

    Integer id(int id);
}
