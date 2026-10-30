package com.bicoja.bicoja.candidatura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidaturaRepository extends JpaRepository<CandidaturaEntity, Long> {

    List<CandidaturaEntity> findByVagaId(Long vagaId);

    List<CandidaturaEntity> findByProfissionalId(Long profissionalId);

    boolean existsByVagaIdAndProfissionalId(Long vagaId, Long profissionalId);

    Optional<CandidaturaEntity> findByVagaIdAndProfissionalId(Long vagaId, Long profissionalId);
}