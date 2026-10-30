package com.bicoja.bicoja.contratacao;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ContratacaoDTO {

    @NotNull(message = "O ID da vaga é obrigatório.")
    private Long vagaId;

    @NotNull(message = "O ID do contratante é obrigatório.")
    private Long contratanteId;

    @NotNull(message = "O ID do profissional é obrigatório.")
    private Long profissionalId;

    @NotNull(message = "O valor acordado é obrigatório.")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero.")
    private BigDecimal valorAcordado;

    public Long getVagaId() { return vagaId; }
    public void setVagaId(Long vagaId) { this.vagaId = vagaId; }

    public Long getContratanteId() { return contratanteId; }
    public void setContratanteId(Long contratanteId) { this.contratanteId = contratanteId; }

    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) { this.profissionalId = profissionalId; }

    public BigDecimal getValorAcordado() { return valorAcordado; }
    public void setValorAcordado(BigDecimal valorAcordado) { this.valorAcordado = valorAcordado; }
}