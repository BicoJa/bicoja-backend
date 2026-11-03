package com.bicoja.bicoja.avaliacao;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.bicoja.bicoja.contratacao.Contratacao;
import com.bicoja.bicoja.usuario.Usuario;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_contratacao", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Contratacao contratacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_avaliador", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario avaliador;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_avaliado", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario avaliado;

    @Min(1)
    @Max(5)
    @Column(name = "nota")
    private Integer nota;

    @Column(name = "comentario")
    private String comentario;

    public Avaliacao() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Contratacao getContratacao() { return contratacao; }
    public void setContratacao(Contratacao contratacao) { this.contratacao = contratacao; }

    public Usuario getAvaliador() { return avaliador; }
    public void setAvaliador(Usuario avaliador) { this.avaliador = avaliador; }

    public Usuario getAvaliado() { return avaliado; }
    public void setAvaliado(Usuario avaliado) { this.avaliado = avaliado; }

    public Integer getNota() { return nota; }
    public void setNota(Integer nota) { this.nota = nota; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

}