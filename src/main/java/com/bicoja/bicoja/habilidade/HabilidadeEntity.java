package com.bicoja.bicoja.habilidade;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_habilidades")
public class HabilidadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String nome;

    private String descricao;

    private String iconeUrl;

    public HabilidadeEntity() {}

    public HabilidadeEntity(String nome, String descricao, String iconeUrl) {
        this.nome = nome;
        this.descricao = descricao;
        this.iconeUrl = iconeUrl;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getIconeUrl() { return iconeUrl; }
    public void setIconeUrl(String iconeUrl) { this.iconeUrl = iconeUrl; }
}