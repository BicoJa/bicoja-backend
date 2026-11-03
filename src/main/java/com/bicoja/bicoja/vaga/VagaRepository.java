package com.bicoja.bicoja.vaga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VagaRepository extends JpaRepository<VagaEntity, Integer> {

    List<VagaEntity> findDistinctByHabilidade_IdInAndStatus(
            List<Integer> habilidadesIds,
            StatusVaga status
    );

    @Query("""
        SELECT v
        FROM VagaEntity v
        WHERE v.contratante.id_usuario = :idUsuario
          AND v.status = :status
    """)
    List<VagaEntity> buscarPorContratanteEStatus(
            @Param("idUsuario") Integer idUsuario,
            @Param("status") StatusVaga status
    );
}
