package com.bicoja.bicoja.profissionalhabilidade;

import com.bicoja.bicoja.habilidade.HabilidadeEntity;
import com.bicoja.bicoja.profissional.ProfissionalEntity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROFISSIONAL_HABILIDADE")
public class ProfissionalHabilidadeEntity {

    @EmbeddedId
    private ProfissionalHabilidadeId id;

    @ManyToOne
    @MapsId("id_profissional")
    @JoinColumn(name = "id_profissional")
    private ProfissionalEntity profissional;

    @ManyToOne
    @MapsId("id_habilidade")
    @JoinColumn(name = "id_habilidade")
    private HabilidadeEntity habilidade;

    public ProfissionalHabilidadeEntity() {
    }

    public ProfissionalHabilidadeId getId() {
        return id;
    }

    public void setId(ProfissionalHabilidadeId id) {
        this.id = id;
    }

    public ProfissionalEntity getProfissional() {
        return profissional;
    }

    public void setProfissional(ProfissionalEntity profissional) {
        this.profissional = profissional;
    }

    public HabilidadeEntity getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(HabilidadeEntity habilidade) {
        this.habilidade = habilidade;
    }

}
