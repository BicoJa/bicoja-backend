package com.bicoja.bicoja.contratante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContratanteRepository extends JpaRepository<ContratanteEntity, Long> {

    Optional<ContratanteEntity> findByUsuarioId(Long usuarioId);

    boolean existsByUsuarioId(Long usuarioId);
}