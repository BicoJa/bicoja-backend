package com.bicoja.bicoja.contratacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContratacaoRepository extends JpaRepository<ContratacaoEntity, Integer> {

    // Lista as contratações de um profissional
    @Query("""
        SELECT c
        FROM ContratacaoEntity c
        WHERE c.profissional.id_usuario = :idUsuario
        ORDER BY c.dataContratacao DESC
    """)
    List<ContratacaoEntity> buscarPorProfissional(
            @Param("idUsuario") Integer idUsuario
    );

    // Lista as contratações de um profissional por status
    @Query("""
        SELECT c
        FROM ContratacaoEntity c
        WHERE c.profissional.id_usuario = :idUsuario
          AND c.status = :status
        ORDER BY c.dataContratacao DESC
    """)
    List<ContratacaoEntity> buscarPorProfissionalEStatus(
            @Param("idUsuario") Integer idUsuario,
            @Param("status") StatusContratacao status
    );

    // Verifica se já existe contratação para a vaga e profissional
    @Query("""
        SELECT COUNT(c) > 0
        FROM ContratacaoEntity c
        WHERE c.vaga.id = :idVaga
          AND c.profissional.id_usuario = :idUsuario
    """)
    boolean existeContratacao(
            @Param("idVaga") Integer idVaga,
            @Param("idUsuario") Integer idUsuario
    );
}