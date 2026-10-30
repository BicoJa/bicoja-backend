package com.bicoja.bicoja.notificacao;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_notificacoes")
public class NotificacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long usuarioId; // ID do utilizador que recebe a notificação

    @Column(nullable = false, length = 500)
    private String mensagem;

    @Column(nullable = false)
    private boolean lida = false;

    @Column(nullable = false)
    private LocalDateTime dataEnvio = LocalDateTime.now();

    public NotificacaoEntity() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    public boolean isLida() { return lida; }
    public void setLida(boolean lida) { this.lida = lida; }
    public LocalDateTime getDataEnvio() { return dataEnvio; }
    public void setDataEnvio(LocalDateTime dataEnvio) { this.dataEnvio = dataEnvio; }
}