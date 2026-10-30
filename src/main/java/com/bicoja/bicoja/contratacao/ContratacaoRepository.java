package com.bicoja.bicoja.contratacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratacaoRepository extends JpaRepository<ContratacaoEntity, Long> {

    List<ContratacaoEntity> findByContratanteId(Long contratanteId);

    List<ContratacaoEntity> findByProfissionalId(Long profissionalId);

    boolean existsByVagaIdAndStatus(Long vagaId, ContratacaoEntity.StatusContratacao status);
}