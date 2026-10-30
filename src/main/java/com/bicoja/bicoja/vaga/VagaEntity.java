package com.bicoja.bicoja.vaga;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_vagas")
public class VagaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 1000)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal orcamento;

    @Column(nullable = false)
    private String status = "ABERTA"; // ABERTA, EM_ANDAMENTO, CONCLUIDA, CANCELADA

    @Column(nullable = false)
    private Long contratanteId; // ID do contratante que publicou a vaga

    @ElementCollection
    @CollectionTable(name = "tb_vaga_habilidades", joinColumns = @JoinColumn(name = "vaga_id"))
    @Column(name = "habilidade")
    private List<String> habilidadesRequeridas;

    public VagaEntity() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public BigDecimal getOrcamento() { return orcamento; }
    public void setOrcamento(BigDecimal orcamento) { this.orcamento = orcamento; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Long getContratanteId() { return contratanteId; }
    public void setContratanteId(Long contratanteId) { this.contratanteId = contratanteId; }
    public List<String> getHabilidadesRequeridas() { return habilidadesRequeridas; }
    public void setHabilidadesRequeridas(List<String> habilidadesRequeridas) { this.habilidadesRequeridas = habilidadesRequeridas; }
}