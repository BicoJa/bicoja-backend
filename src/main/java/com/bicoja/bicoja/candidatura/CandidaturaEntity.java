package com.bicoja.bicoja.candidatura;

import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusCandidatura status = StatusCandidatura.PENDENTE;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCandidatura = LocalDateTime.now();

    public enum StatusCandidatura {
        PENDENTE,
        ACEITA,
        RECUSADA,
        CANCELADA
    }

    public CandidaturaEntity() {}

    public CandidaturaEntity(Long vagaId, Long profissionalId) {
        this.vagaId = vagaId;
        this.profissionalId = profissionalId;
        this.status = StatusCandidatura.PENDENTE;
        this.dataCandidatura = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getVagaId() { return vagaId; }
    public void setVagaId(Long vagaId) { this.vagaId = vagaId; }

    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) { this.profissionalId = profissionalId; }

    public StatusCandidatura getStatus() { return status; }
    public void setStatus(StatusCandidatura status) { this.status = status; }

    public LocalDateTime getDataCandidatura() { return dataCandidatura; }
    public void setDataCandidatura(LocalDateTime dataCandidatura) { this.dataCandidatura = dataCandidatura; }
}
