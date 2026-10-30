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
    private Long profissionalId;

    @Column(nullable = false)
    private Long contratanteId;

    @Column(nullable = false)
    private BigDecimal valorAcordado;

    @Column(nullable = false)
    private String status = "EM_ANDAMENTO"; // EM_ANDAMENTO, CONCLUIDA, CANCELADA

    @Column(nullable = false)
    private LocalDateTime dataContratacao = LocalDateTime.now();

    public ContratacaoEntity() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getVagaId() { return vagaId; }
    public void setVagaId(Long vagaId) { this.vagaId = vagaId; }
    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) { this.profissionalId = profissionalId; }
    public Long getContratanteId() { return contratanteId; }
    public void setContratanteId(Long contratanteId) { this.contratanteId = contratanteId; }
    public BigDecimal getValorAcordado() { return valorAcordado; }
    public void setValorAcordado(BigDecimal valorAcordado) { this.valorAcordado = valorAcordado; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getDataContratacao() { return dataContratacao; }
    public void setDataContratacao(LocalDateTime dataContratacao) { this.dataContratacao = dataContratacao; }
}