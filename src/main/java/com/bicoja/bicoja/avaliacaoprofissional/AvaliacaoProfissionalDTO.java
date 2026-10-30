package com.bicoja.bicoja.avaliacaoprofissional;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class AvaliacaoProfissionalDTO {

    @NotNull(message = "O ID do profissional é obrigatório.")
    private Long profissionalId;

    @NotNull(message = "O ID do contratante é obrigatório.")
    private Long contratanteId;

    @NotNull(message = "A nota é obrigatória.")
    @Min(value = 1, message = "A nota mínima é 1.")
    @Max(value = 5, message = "A nota máxima é 5.")
    private Integer nota;

    private String comentario;

    // Getters e Setters
    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) { this.profissionalId = profissionalId; }
    public Long getContratanteId() { return contratanteId; }
    public void setContratanteId(Long contratanteId) { this.contratanteId = contratanteId; }
    public Integer getNota() { return nota; }
    public void setNota(Integer nota) { this.nota = nota; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
}