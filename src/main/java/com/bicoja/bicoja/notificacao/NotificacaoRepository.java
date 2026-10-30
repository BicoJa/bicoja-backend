package com.bicoja.bicoja.notificacao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificacaoRepository extends JpaRepository<NotificacaoEntity, Long> {
    List<NotificacaoEntity> findByUsuarioId(Long usuarioId);
    List<NotificacaoEntity> findByUsuarioIdAndLida(Long usuarioId, boolean lida);
}