package com.bicoja.bicoja.contratacao;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.bicoja.bicoja.vaga.Vaga;
import com.bicoja.bicoja.profissional.Profissional;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "contratacao")
public class Contratacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_vaga", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Vaga vaga;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_profissional", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Profissional profissional;

    @Column(name = "status")
    private String status;

    public Contratacao() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Vaga getVaga() { return vaga; }
    public void setVaga(Vaga vaga) { this.vaga = vaga; }

    public Profissional getProfissional() { return profissional; }
    public void setProfissional(Profissional profissional) { this.profissional = profissional; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}