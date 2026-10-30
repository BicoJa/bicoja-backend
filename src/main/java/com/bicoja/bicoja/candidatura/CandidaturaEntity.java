package com.bicoja.bicoja.candidatura;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_candidaturas")
public class CandidaturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long vagaId;

    @Column(nullable = false)
    private Long profissionalId;

    @Column(nullable = false)
    private BigDecimal valorProposta;

    @Column(length = 500)
    private String mensagem;

    @Column(nullable = false)
    private String status = "PENDENTE"; // PENDENTE, ACEITA, RECUSADA

    @Column(nullable = false)
    private LocalDateTime dataCandidatura = LocalDateTime.now();

    public CandidaturaEntity() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getVagaId() { return vagaId; }
    public void setVagaId(Long vagaId) { this.vagaId = vagaId; }
    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) { this.profissionalId = profissionalId; }
    public BigDecimal getValorProposta() { return valorProposta; }
    public void setValorProposta(BigDecimal valorProposta) { this.valorProposta = valorProposta; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getDataCandidatura() { return dataCandidatura; }
    public void setDataCandidatura(LocalDateTime dataCandidatura) { this.dataCandidatura = dataCandidatura; }
}