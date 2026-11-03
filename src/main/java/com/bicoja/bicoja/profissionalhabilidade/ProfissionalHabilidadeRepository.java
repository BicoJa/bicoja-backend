package com.bicoja.bicoja.profissionalhabilidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfissionalHabilidadeRepository
        extends JpaRepository<ProfissionalHabilidadeEntity, ProfissionalHabilidadeId> {

    @Query("""
        SELECT ph
        FROM ProfissionalHabilidadeEntity ph
        WHERE ph.profissional.id_usuario = :idUsuario
    """)
    List<ProfissionalHabilidadeEntity> buscarPorIdUsuario(
            @Param("idUsuario") Integer idUsuario
    );
}
