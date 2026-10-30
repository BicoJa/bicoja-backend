package com.bicoja.bicoja.contratacao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContratacaoRepository extends JpaRepository<ContratacaoEntity, Long> {
    List<ContratacaoEntity> findByProfissionalId(Long profissionalId);
    List<ContratacaoEntity> findByContratanteId(Long contratanteId);
}