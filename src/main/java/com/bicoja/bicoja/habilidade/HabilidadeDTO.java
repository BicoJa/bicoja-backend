package com.bicoja.bicoja.habilidade;

import jakarta.validation.constraints.NotBlank;

public class HabilidadeDTO {

    @NotBlank(message = "O nome da habilidade é obrigatório.")
    private String nome;

    private String descricao;

    private String iconeUrl;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getIconeUrl() { return iconeUrl; }
    public void setIconeUrl(String iconeUrl) { this.iconeUrl = iconeUrl; }
}