package com.bicoja.bicoja.avaliacaoprofissional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AvaliacaoProfissionalRepository
        extends JpaRepository<AvaliacaoProfissionalEntity, Integer> {

    boolean existsByContratacao_Id(Integer idContratacao);

    @Query("""
        SELECT a
        FROM AvaliacaoProfissionalEntity a
        WHERE a.profissional.id_usuario = :idUsuario
    """)
    List<AvaliacaoProfissionalEntity> buscarPorProfissional(
            @Param("idUsuario") Integer idUsuario
    );
}