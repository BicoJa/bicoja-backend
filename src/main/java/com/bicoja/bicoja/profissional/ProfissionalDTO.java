package com.bicoja.bicoja.profissional;

import jakarta.validation.constraints.NotNull;

public class ProfissionalDTO {

    @NotNull(message = "O ID do usuário é obrigatório.")
    private Long usuarioId;

    private String biografia;

    private String cpf;

    private String cidade;

    private String estado;

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getBiografia() { return biografia; }
    public void setBiografia(String biografia) { this.biografia = biografia; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}