package com.bicoja.bicoja.candidatura;

import com.bicoja.bicoja.profissional.ProfissionalEntity;
import com.bicoja.bicoja.vaga.VagaEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "CANDIDATURA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidaturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_vaga", nullable = false)
    private VagaEntity vaga;

    @ManyToOne
    @JoinColumn(name = "id_profissional", nullable = false)
    private ProfissionalEntity profissional;

}
