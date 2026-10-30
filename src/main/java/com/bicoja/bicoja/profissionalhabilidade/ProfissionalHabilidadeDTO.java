package com.bicoja.bicoja.profissionalhabilidade;

import jakarta.validation.constraints.NotNull;

public class ProfissionalHabilidadeDTO {

    @NotNull(message = "O ID do profissional é obrigatório.")
    private Long profissionalId;

    @NotNull(message = "O ID da habilidade é obrigatório.")
    private Long habilidadeId;

    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) { this.profissionalId = profissionalId; }

    public Long getHabilidadeId() { return habilidadeId; }
    public void setHabilidadeId(Long habilidadeId) { this.habilidadeId = habilidadeId; }
}