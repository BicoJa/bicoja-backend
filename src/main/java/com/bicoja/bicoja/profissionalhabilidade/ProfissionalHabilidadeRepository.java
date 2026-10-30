package com.bicoja.bicoja.profissionalhabilidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfissionalHabilidadeRepository extends JpaRepository<ProfissionalHabilidadeEntity, ProfissionalHabilidadeId> {

    List<ProfissionalHabilidadeEntity> findByProfissionalId(Long profissionalId);

    List<ProfissionalHabilidadeEntity> findByHabilidadeId(Long habilidadeId);

    boolean existsByProfissionalIdAndHabilidadeId(Long profissionalId, Long habilidadeId);

    void deleteByProfissionalIdAndHabilidadeId(Long profissionalId, Long habilidadeId);
}