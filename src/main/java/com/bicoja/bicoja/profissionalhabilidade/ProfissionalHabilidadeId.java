package com.bicoja.bicoja.profissionalhabilidade;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProfissionalHabilidadeId implements Serializable {

    private Integer id_profissional;
    private Integer id_habilidade;

    public ProfissionalHabilidadeId() {
    }

    public ProfissionalHabilidadeId(Integer id_profissional, Integer id_habilidade) {
        this.id_profissional = id_profissional;
        this.id_habilidade = id_habilidade;
    }

    public Integer getId_profissional() {
        return id_profissional;
    }

    public void setId_profissional(Integer id_profissional) {
        this.id_profissional = id_profissional;
    }

    public Integer getId_habilidade() {
        return id_habilidade;
    }

    public void setId_habilidade(Integer id_habilidade) {
        this.id_habilidade = id_habilidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfissionalHabilidadeId)) return false;
        ProfissionalHabilidadeId that = (ProfissionalHabilidadeId) o;
        return Objects.equals(id_profissional, that.id_profissional)
                && Objects.equals(id_habilidade, that.id_habilidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_profissional, id_habilidade);
    }

}
