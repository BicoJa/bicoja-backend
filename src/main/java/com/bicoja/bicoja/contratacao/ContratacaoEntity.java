package com.bicoja.bicoja.contratacao;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_contratacoes")
public class ContratacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long vagaId;

    @Column(nullable = false)
    private Long contratanteId;

    @Column(nullable = false)
    private Long profissionalId;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorAcordado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusContratacao status = StatusContratacao.EM_ANDAMENTO;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataInicio = LocalDateTime.now();

    private LocalDateTime dataConclusao;

    public enum StatusContratacao {
        EM_ANDAMENTO,
        CONCLUIDA,
        CANCELADA
    }

    public ContratacaoEntity() {}

    public ContratacaoEntity(Long vagaId, Long contratanteId, Long profissionalId, BigDecimal valorAcordado) {
        this.vagaId = vagaId;
        this.contratanteId = contratanteId;
        this.profissionalId = profissionalId;
        this.valorAcordado = valorAcordado;
        this.status = StatusContratacao.EM_ANDAMENTO;
        this.dataInicio = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getVagaId() { return vagaId; }
    public void setVagaId(Long vagaId) { this.vagaId = vagaId; }

    public Long getContratanteId() { return contratanteId; }
    public void setContratanteId(Long contratanteId) { this.contratanteId = contratanteId; }

    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) { this.profissionalId = profissionalId; }

    public BigDecimal getValorAcordado() { return valorAcordado; }
    public void setValorAcordado(BigDecimal valorAcordado) { this.valorAcordado = valorAcordado; }

    public StatusContratacao getStatus() { return status; }
    public void setStatus(StatusContratacao status) { this.status = status; }

    public LocalDateTime getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDateTime dataInicio) { this.dataInicio = dataInicio; }

    public LocalDateTime getDataConclusao() { return dataConclusao; }
    public void setDataConclusao(LocalDateTime dataConclusao) { this.dataConclusao = dataConclusao; }
}