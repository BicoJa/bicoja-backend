package com.bicoja.bicoja.profissionalhabilidade;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProfissionalHabilidadeRepository extends JpaRepository<ProfissionalHabilidadeEntity, ProfissionalHabilidadeId> {
    List<ProfissionalHabilidadeEntity> findByProfissionalId(Long profissionalId);
    List<ProfissionalHabilidadeEntity> findByHabilidadeId(Long habilidadeId);
}