package com.bicoja.bicoja.avaliacaoprofissional;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_avaliacoes_profissional")
public class AvaliacaoProfissionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long profissionalId;

    @Column(nullable = false)
    private Long contratanteId;

    @Column(nullable = false)
    private Integer nota; // Ex: de 1 a 5

    @Column(columnDefinition = "TEXT")
    private String comentario;

    @Column(nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public AvaliacaoProfissionalEntity() {}

    public AvaliacaoProfissionalEntity(Long profissionalId, Long contratanteId, Integer nota, String comentario) {
        this.profissionalId = profissionalId;
        this.contratanteId = contratanteId;
        this.nota = nota;
        this.comentario = comentario;
        this.dataCriacao = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) { this.profissionalId = profissionalId; }
    public Long getContratanteId() { return contratanteId; }
    public void setContratanteId(Long contratanteId) { this.contratanteId = contratanteId; }
    public Integer getNota() { return nota; }
    public void setNota(Integer nota) { this.nota = nota; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}