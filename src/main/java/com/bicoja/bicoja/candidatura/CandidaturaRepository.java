package com.bicoja.bicoja.candidatura;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CandidaturaRepository extends JpaRepository<CandidaturaEntity, Long> {
    List<CandidaturaEntity> findByVagaId(Long vagaId);
    List<CandidaturaEntity> findByProfissionalId(Long profissionalId);
}