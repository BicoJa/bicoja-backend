package com.bicoja.bicoja.vaga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<VagaEntity, Long> {

    List<VagaEntity> findByStatusOrderByDataCriacaoDesc(VagaEntity.StatusVaga status);

    List<VagaEntity> findByContratanteIdOrderByDataCriacaoDesc(Long contratanteId);

    List<VagaEntity> findByCategoriaAndStatus(String categoria, VagaEntity.StatusVaga status);

    List<VagaEntity> findByCidadeIgnoreCaseAndEstadoIgnoreCaseAndStatus(String cidade, String estado, VagaEntity.StatusVaga status);
}