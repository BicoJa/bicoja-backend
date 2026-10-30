package com.bicoja.bicoja.notificacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NotificacaoDTO {

    @NotNull(message = "O ID do usuário é obrigatório.")
    private Long usuarioId;

    @NotBlank(message = "O título da notificação é obrigatório.")
    private String titulo;

    @NotBlank(message = "A mensagem da notificação é obrigatória.")
    private String mensagem;

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
}