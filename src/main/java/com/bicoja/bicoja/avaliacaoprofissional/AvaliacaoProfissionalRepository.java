package com.bicoja.bicoja.avaliacaoprofissional;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AvaliacaoProfissionalRepository extends JpaRepository<AvaliacaoProfissionalEntity, Long> {
    List<AvaliacaoProfissionalEntity> findByProfissionalId(Long profissionalId);
}