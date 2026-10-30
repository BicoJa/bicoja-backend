package com.bicoja.bicoja.habilidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HabilidadeRepository extends JpaRepository<HabilidadeEntity, Long> {

    Optional<HabilidadeEntity> findByNomeIgnoreCase(String nome);

    boolean existsByNomeIgnoreCase(String nome);
}