package com.bicoja.bicoja.usuario;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nomeCompleto;

    @Column(nullable = false, unique = true, length = 20)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoUsuario tipoUsuario;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_usuario_servicos", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "servico")
    private List<String> servicos;

    @Column(nullable = false)
    private boolean telefoneVerificado = false;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public enum TipoUsuario {
        PROFISSIONAL,
        CONTRATANTE
    }

    public UsuarioEntity() {}

    public UsuarioEntity(String nomeCompleto, String telefone, TipoUsuario tipoUsuario, List<String> servicos) {
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
        this.tipoUsuario = tipoUsuario;
        this.servicos = servicos;
        this.telefoneVerificado = false;
        this.dataCriacao = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public TipoUsuario getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(TipoUsuario tipoUsuario) { this.tipoUsuario = tipoUsuario; }

    public List<String> getServicos() { return servicos; }
    public void setServicos(List<String> servicos) { this.servicos = servicos; }

    public boolean isTelefoneVerificado() { return telefoneVerificado; }
    public void setTelefoneVerificado(boolean telefoneVerificado) { this.telefoneVerificado = telefoneVerificado; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}
