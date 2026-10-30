package com.bicoja.bicoja.avaliacaoprofissional;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_avaliacao_profissional")
public class AvaliacaoProfissionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long contratacaoId; // ID da contratação vinculada

    @Column(nullable = false)
    private Long avaliadorId; // ID do contratante que avaliou

    @Column(nullable = false)
    private Long profissionalId; // ID do profissional avaliado

    @Column(nullable = false)
    private Integer nota; // Ex: de 1 a 5

    @Column(length = 500)
    private String comentario;

    @Column(nullable = false)
    private LocalDateTime dataAvaliacao = LocalDateTime.now();

    public AvaliacaoProfissionalEntity() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getContratacaoId() { return contratacaoId; }
    public void setContratacaoId(Long contratacaoId) { this.contratacaoId = contratacaoId; }
    public Long getAvaliadorId() { return avaliadorId; }
    public void setAvaliadorId(Long avaliadorId) { this.avaliadorId = avaliadorId; }
    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) { this.profissionalId = profissionalId; }
    public Integer getNota() { return nota; }
    public void setNota(Integer nota) { this.nota = nota; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public LocalDateTime getDataAvaliacao() { return dataAvaliacao; }
    public void setDataAvaliacao(LocalDateTime dataAvaliacao) { this.dataAvaliacao = dataAvaliacao; }
}