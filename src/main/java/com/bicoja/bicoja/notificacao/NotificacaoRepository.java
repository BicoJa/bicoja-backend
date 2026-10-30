package com.bicoja.bicoja.notificacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacaoRepository extends JpaRepository<NotificacaoEntity, Long> {

    List<NotificacaoEntity> findByUsuarioIdOrderByDataCriacaoDesc(Long usuarioId);

    List<NotificacaoEntity> findByUsuarioIdAndLidaFalseOrderByDataCriacaoDesc(Long usuarioId);

    long countByUsuarioIdAndLidaFalse(Long usuarioId);
}