package com.bicoja.bicoja.fototrabalho;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_fotos_trabalho")
public class FotoTrabalhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long profissionalId;

    @Column(nullable = false, length = 500)
    private String urlFoto;

    @Column(length = 255)
    private String descricao;

    public FotoTrabalhoEntity() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) { this.profissionalId = profissionalId; }
    public String getUrlFoto() { return urlFoto; }
    public void setUrlFoto(String urlFoto) { this.urlFoto = urlFoto; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}