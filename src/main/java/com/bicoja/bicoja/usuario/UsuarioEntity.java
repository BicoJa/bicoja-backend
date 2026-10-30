package com.bicoja.bicoja.usuario;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCompleto;

    @Column(nullable = false, unique = true)
    private String telefone;

    @Column(nullable = false)
    private String tipoUsuario; // "PROFISSIONAL" ou "CONTRATANTE"

    @ElementCollection
    @CollectionTable(name = "tb_usuario_servicos", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "servico")
    private List<String> servicos;

    @Column(nullable = false)
    private boolean telefoneVerificado = false;

    private String tokenOtp; // Token temporário para SMS

    public UsuarioEntity() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }
    public List<String> getServicos() { return servicos; }
    public void setServicos(List<String> servicos) { this.servicos = servicos; }
    public boolean isTelefoneVerificado() { return telefoneVerificado; }
    public void setTelefoneVerificado(boolean telefoneVerificado) { this.telefoneVerificado = telefoneVerificado; }
    public String getTokenOtp() { return tokenOtp; }
    public void setTokenOtp(String tokenOtp) { this.tokenOtp = tokenOtp; }
}