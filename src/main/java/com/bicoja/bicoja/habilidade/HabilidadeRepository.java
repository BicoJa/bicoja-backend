package com.bicoja.bicoja.habilidade;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HabilidadeRepository extends JpaRepository<HabilidadeEntity, Long> {
    Optional<HabilidadeEntity> findByNome(String nome);
    boolean existsByNome(String nome);
}