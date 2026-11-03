package com.bicoja.bicoja.habilidade;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HabilidadeRepository extends JpaRepository<HabilidadeEntity, Integer> {
    Optional<HabilidadeEntity> findByNome(String nome);
}