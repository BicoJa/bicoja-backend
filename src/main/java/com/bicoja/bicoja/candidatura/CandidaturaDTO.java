package com.bicoja.bicoja.candidatura;

import jakarta.validation.constraints.NotNull;

public class CandidaturaDTO {

    @NotNull(message = "O ID da vaga é obrigatório.")
    private Long vagaId;

    @NotNull(message = "O ID do profissional é obrigatório.")
    private Long profissionalId;

    public Long getVagaId() { return vagaId; }
    public void setVagaId(Long vagaId) { this.vagaId = vagaId; }

    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) { this.profissionalId = profissionalId; }
}