package com.bicoja.bicoja.profissionalhabilidade;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalHabilidadeId implements Serializable {

    private Integer id_profissional;

    private Integer id_habilidade;

}
