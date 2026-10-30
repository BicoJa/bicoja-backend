package com.bicoja.bicoja.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByTelefone(String telefone);
    boolean existsByTelefone(String telefone);
}