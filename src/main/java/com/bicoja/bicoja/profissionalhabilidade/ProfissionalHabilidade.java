package com.bicoja.bicoja.profissionalhabilidade;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.bicoja.bicoja.profissional.Profissional;
import com.bicoja.bicoja.habilidade.Habilidade;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "profissionalhabilidade")
public class ProfissionalHabilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfissionalHabilidade;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_profissional", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Profissional profissional;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_habilidade", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Habilidade habilidade;

    public ProfissionalHabilidade() {}

    public Long getIdProfissionalHabilidade() { return idProfissionalHabilidade; }
    public void setIdProfissionalHabilidade(Long idProfissionalHabilidade) { this.idProfissionalHabilidade = idProfissionalHabilidade; }

    public Profissional getProfissional() { return profissional; }
    public void setProfissional(Profissional profissional) { this.profissional = profissional; }

    public Habilidade getHabilidade() { return habilidade; }
    public void setHabilidade(Habilidade habilidade) { this.habilidade = habilidade; }

}