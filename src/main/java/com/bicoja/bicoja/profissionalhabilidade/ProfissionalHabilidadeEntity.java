package com.bicoja.bicoja.profissionalhabilidade;

import com.bicoja.bicoja.habilidade.HabilidadeEntity;
import com.bicoja.bicoja.profissional.ProfissionalEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "PROFISSIONAL_HABILIDADE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalHabilidadeEntity {

    @EmbeddedId
    private ProfissionalHabilidadeId id;

    @ManyToOne
    @MapsId("id_profissional")
    @JoinColumn(name = "id_profissional", nullable = false)
    private ProfissionalEntity profissional;

    @ManyToOne
    @MapsId("id_habilidade")
    @JoinColumn(name = "id_habilidade", nullable = false)
    private HabilidadeEntity habilidade;

}
