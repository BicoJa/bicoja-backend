package com.bicoja.bicoja.notificacao.dto;

import java.time.LocalDateTime;
import com.bicoja.bicoja.notificacao.NotificacaoEntity;

public record NotificacaoResponseDTO(
        Integer id,
        Integer idUsuario,
        String mensagem,
        LocalDateTime dataCriacao,
        Boolean lida
) {
    public static NotificacaoResponseDTO fromEntity(NotificacaoEntity notificacao) {
        return new NotificacaoResponseDTO(
                notificacao.getId(),
                notificacao.getUsuario().getId_usuario(),
                notificacao.getMensagem(),
                notificacao.getDataCriacao(),
                notificacao.getLida()
        );
    }
}