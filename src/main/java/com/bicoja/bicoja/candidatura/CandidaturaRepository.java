package com.bicoja.bicoja.candidatura;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidaturaRepository extends JpaRepository<CandidaturaEntity, Integer> {

    // Verifica se o profissional já se candidatou à vaga
    @Query("""
        SELECT COUNT(c) > 0
        FROM CandidaturaEntity c
        WHERE c.vaga.id = :idVaga
          AND c.profissional.id_usuario = :idUsuario
    """)
    boolean existeCandidatura(
            @Param("idVaga") Integer idVaga,
            @Param("idUsuario") Integer idUsuario
    );

    // Busca todas as candidaturas de um profissional
    @Query("""
        SELECT c
        FROM CandidaturaEntity c
        WHERE c.profissional.id_usuario = :idUsuario
    """)
    List<CandidaturaEntity> buscarPorProfissional(
            @Param("idUsuario") Integer idUsuario
    );

    // Busca todas as candidaturas de uma vaga
    List<CandidaturaEntity> findByVaga_Id(Integer idVaga);

    @Query("""
    SELECT c
    FROM CandidaturaEntity c
    WHERE c.profissional.id_usuario = :idUsuario
      AND c.status = :status
""")
    List<CandidaturaEntity> buscarPorProfissionalEStatus(
            @Param("idUsuario") Integer idUsuario,
            @Param("status") StatusCandidatura status
    );


    @Query("""
    SELECT c
    FROM CandidaturaEntity c
    WHERE c.vaga.id = :idVaga
      AND c.status = :status
""")
    List<CandidaturaEntity> buscarPorVagaEStatus(
            @Param("idVaga") Integer idVaga,
            @Param("status") StatusCandidatura status
    );
}