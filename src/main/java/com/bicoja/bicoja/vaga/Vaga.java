package com.bicoja.bicoja.vaga;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.bicoja.bicoja.contratante.Contratante;
import com.bicoja.bicoja.habilidade.Habilidade;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "vaga")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_contratante", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Contratante contratante;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_habilidade", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Habilidade habilidade;

    @NotBlank
    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "status")
    private String status;

    public Vaga() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Contratante getContratante() { return contratante; }
    public void setContratante(Contratante contratante) { this.contratante = contratante; }

    public Habilidade getHabilidade() { return habilidade; }
    public void setHabilidade(Habilidade habilidade) { this.habilidade = habilidade; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}