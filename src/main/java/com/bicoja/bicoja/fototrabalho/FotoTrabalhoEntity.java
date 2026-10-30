package com.bicoja.bicoja.fototrabalho;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_fotos_trabalho")
public class FotoTrabalhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long profissionalId;

    @Column(nullable = false)
    private String urlFoto;

    private String descricao;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataEnvio = LocalDateTime.now();

    public FotoTrabalhoEntity() {}

    public FotoTrabalhoEntity(Long profissionalId, String urlFoto, String descricao) {
        this.profissionalId = profissionalId;
        this.urlFoto = urlFoto;
        this.descricao = descricao;
        this.dataEnvio = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) { this.profissionalId = profissionalId; }

    public String getUrlFoto() { return urlFoto; }
    public void setUrlFoto(String urlFoto) { this.urlFoto = urlFoto; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDateTime getDataEnvio() { return dataEnvio; }
    public void setDataEnvio(LocalDateTime dataEnvio) { this.dataEnvio = dataEnvio; }
}