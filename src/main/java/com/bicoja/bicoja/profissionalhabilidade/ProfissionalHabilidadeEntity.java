package com.bicoja.bicoja.profissionalhabilidade;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_profissional_habilidade")
@IdClass(ProfissionalHabilidadeId.class)
public class ProfissionalHabilidadeEntity {

    @Id
    private Long profissionalId;

    @Id
    private Long habilidadeId;

    public ProfissionalHabilidadeEntity() {}

    public ProfissionalHabilidadeEntity(Long profissionalId, Long habilidadeId) {
        this.profissionalId = profissionalId;
        this.habilidadeId = habilidadeId;
    }

    // Getters e Setters
    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) { this.profissionalId = profissionalId; }
    public Long getHabilidadeId() { return habilidadeId; }
    public void setHabilidadeId(Long habilidadeId) { this.habilidadeId = habilidadeId; }
}