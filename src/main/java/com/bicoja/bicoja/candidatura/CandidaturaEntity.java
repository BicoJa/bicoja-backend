package com.bicoja.bicoja.candidatura;

import com.bicoja.bicoja.profissional.ProfissionalEntity;
import com.bicoja.bicoja.vaga.VagaEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "CANDIDATURA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidaturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vaga", nullable = false)
    private VagaEntity vaga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profissional", nullable = false)
    private ProfissionalEntity profissional;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusCandidatura status;

    @PrePersist
    public void prePersist() {
        if (this.status == null) {
            this.status = StatusCandidatura.PENDENTE;
        }
    }
}