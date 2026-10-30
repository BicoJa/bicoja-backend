package com.bicoja.bicoja.profissionalhabilidade;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProfissionalHabilidadeId implements Serializable {

    private Long profissionalId;
    private Long habilidadeId;

    public ProfissionalHabilidadeId() {}

    public ProfissionalHabilidadeId(Long profissionalId, Long habilidadeId) {
        this.profissionalId = profissionalId;
        this.habilidadeId = habilidadeId;
    }

    public Long getProfissionalId() { return profissionalId; }
    public void setProfissionalId(Long profissionalId) { this.profissionalId = profissionalId; }

    public Long getHabilidadeId() { return habilidadeId; }
    public void setHabilidadeId(Long habilidadeId) { this.habilidadeId = habilidadeId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfissionalHabilidadeId that = (ProfissionalHabilidadeId) o;
        return Objects.equals(profissionalId, that.profissionalId) &&
                Objects.equals(habilidadeId, that.habilidadeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profissionalId, habilidadeId);
    }
}
