package com.bicoja.bicoja.fototrabalho;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.bicoja.bicoja.profissional.Profissional;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "fototrabalho")
public class FotoTrabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_profissional", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Profissional profissional;

    @Column(name = "url")
    private String url;

    @Column(name = "descricao")
    private String descricao;

    public FotoTrabalho() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Profissional getProfissional() { return profissional; }
    public void setProfissional(Profissional profissional) { this.profissional = profissional; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

}