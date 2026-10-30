package com.bicoja.bicoja.vaga;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VagaRepository extends JpaRepository<VagaEntity, Long> {
    List<VagaEntity> findByStatus(String status);
    List<VagaEntity> findByContratanteId(Long contratanteId);
}