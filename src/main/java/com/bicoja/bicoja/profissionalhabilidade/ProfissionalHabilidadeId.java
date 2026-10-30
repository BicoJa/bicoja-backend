package com.bicoja.bicoja.profissionalhabilidade;

import java.io.Serializable;
import java.util.Objects;

public class ProfissionalHabilidadeId implements Serializable {

    private Long profissionalId;
    private Long habilidadeId;

    public ProfissionalHabilidadeId() {}

    public ProfissionalHabilidadeId(Long profissionalId, Long habilidadeId) {
        this.profissionalId = profissionalId;
        this.habilidadeId = habilidadeId;
    }

    // Equals e HashCode obrigatórios para chaves compostas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfissionalHabilidadeId that = (ProfissionalHabilidadeId) o;
        return Objects.equals(profissionalId, that.profissionalId) && Objects.equals(habilidadeId, that.habilidadeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profissionalId, habilidadeId);
    }
}