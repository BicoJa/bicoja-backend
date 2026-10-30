package com.bicoja.bicoja.usuario;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class CadastroDTO {
    @NotBlank(message = "O nome completo é obrigatório")
    private String nomeCompleto;

    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;

    private List<String> servicos;

    // Getters e Setters
    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public List<String> getServicos() { return servicos; }
    public void setServicos(List<String> servicos) { this.servicos = servicos; }
}