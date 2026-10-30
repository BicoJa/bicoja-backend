package com.bicoja.bicoja.fototrabalho;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FotoTrabalhoDTO {

    @NotNull(message = "O ID do profissional é obrigatório.")
    private Long profissionalId;

    @NotBlank(message = "A URL da foto é obrigatória.")
    private String urlFoto;

    private String descricao;

    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) { this.profissionalId = profissionalId; }

    public String getUrlFoto() { return urlFoto; }
    public void setUrlFoto(String urlFoto) { this.urlFoto = urlFoto; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}