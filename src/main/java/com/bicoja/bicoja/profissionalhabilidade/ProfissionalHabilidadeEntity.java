package com.bicoja.bicoja.profissionalhabilidade;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_profissional_habilidade")
public class ProfissionalHabilidadeEntity {

    @EmbeddedId
    private ProfissionalHabilidadeId id;

    @Column(nullable = false)
    private Long profissionalId;

    @Column(nullable = false)
    private Long habilidadeId;

    public ProfissionalHabilidadeEntity() {}

    public ProfissionalHabilidadeEntity(Long profissionalId, Long habilidadeId) {
        this.profissionalId = profissionalId;
        this.habilidadeId = habilidadeId;
        this.id = new ProfissionalHabilidadeId(profissionalId, habilidadeId);
    }

    public ProfissionalHabilidadeId getId() { return id; }
    public void setId(ProfissionalHabilidadeId id) { this.id = id; }

    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
        this.id.setProfissionalId(profissionalId);
    }

    public Long getHabilidadeId() { return habilidadeId; }
    public void setHabilidadeId(Long habilidadeId) {
        this.habilidadeId = habilidadeId;
        this.id.setHabilidadeId(habilidadeId);
    }
}