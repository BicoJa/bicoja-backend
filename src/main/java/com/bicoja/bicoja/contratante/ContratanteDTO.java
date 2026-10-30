package com.bicoja.bicoja.contratante;

import jakarta.validation.constraints.NotNull;

public class ContratanteDTO {

    @NotNull(message = "O ID do usuário é obrigatório.")
    private Long usuarioId;

    private String empresaOuRazaoSocial;

    private String cpfOuCnpj;

    private String endereco;

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getEmpresaOuRazaoSocial() { return empresaOuRazaoSocial; }
    public void setEmpresaOuRazaoSocial(String empresaOuRazaoSocial) { this.empresaOuRazaoSocial = empresaOuRazaoSocial; }

    public String getCpfOuCnpj() { return cpfOuCnpj; }
    public void setCpfOuCnpj(String cpfOuCnpj) { this.cpfOuCnpj = cpfOuCnpj; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
}