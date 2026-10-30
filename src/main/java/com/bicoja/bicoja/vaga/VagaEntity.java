package com.bicoja.bicoja.vaga;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_vagas")
public class VagaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long contratanteId;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false, length = 100)
    private String categoria; // Ex: Eletricista, Encanador, Pedreiro, etc.

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorOferecido;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusVaga status = StatusVaga.ABERTA;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public enum StatusVaga {
        ABERTA,
        EM_ANDAMENTO,
        CONCLUIDA,
        CANCELADA
    }

    public VagaEntity() {}

    public VagaEntity(Long contratanteId, String titulo, String descricao, String categoria, BigDecimal valorOferecido, String cidade, String estado) {
        this.contratanteId = contratanteId;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valorOferecido = valorOferecido;
        this.cidade = cidade;
        this.estado = estado;
        this.status = StatusVaga.ABERTA;
        this.dataCriacao = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getContratanteId() { return contratanteId; }
    public void setContratanteId(Long contratanteId) { this.contratanteId = contratanteId; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public BigDecimal getValorOferecido() { return valorOferecido; }
    public void setValorOferecido(BigDecimal valorOferecido) { this.valorOferecido = valorOferecido; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public StatusVaga getStatus() { return status; }
    public void setStatus(StatusVaga status) { this.status = status; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}