package com.bicoja.bicoja.notificacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NotificacaoRepository extends JpaRepository<NotificacaoEntity, Integer> {

    // Buscar todas as notificações de um usuário
    @Query("""
        SELECT n
        FROM NotificacaoEntity n
        WHERE n.usuario.id_usuario = :idUsuario
        ORDER BY n.dataCriacao DESC
    """)
    List<NotificacaoEntity> buscarPorUsuario(
            @Param("idUsuario") Integer idUsuario
    );

    // Buscar notificações não lidas
    @Query("""
        SELECT n
        FROM NotificacaoEntity n
        WHERE n.usuario.id_usuario = :idUsuario
          AND n.lida = false
        ORDER BY n.dataCriacao DESC
    """)
    List<NotificacaoEntity> buscarNaoLidas(
            @Param("idUsuario") Integer idUsuario
    );

    // Contar notificações não lidas
    @Query("""
        SELECT COUNT(n)
        FROM NotificacaoEntity n
        WHERE n.usuario.id_usuario = :idUsuario
          AND n.lida = false
    """)
    long contarNaoLidas(
            @Param("idUsuario") Integer idUsuario
    );
}