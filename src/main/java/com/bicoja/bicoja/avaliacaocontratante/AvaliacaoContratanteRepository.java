package com.bicoja.bicoja.avaliacaocontratante;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AvaliacaoContratanteRepository extends JpaRepository<AvaliacaoContratanteEntity, Long> {
    List<AvaliacaoContratanteEntity> findByContratanteId(Long contratanteId);
}