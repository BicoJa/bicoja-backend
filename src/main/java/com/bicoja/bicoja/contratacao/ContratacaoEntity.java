package com.bicoja.bicoja.contratacao;

import com.bicoja.bicoja.profissional.ProfissionalEntity;
import com.bicoja.bicoja.vaga.VagaEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "CONTRATACAO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContratacaoEntity {

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
    private StatusContratacao status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataContratacao;

    @PrePersist
    public void prePersist() {
        this.dataContratacao = LocalDateTime.now();

        if (this.status == null) {
            this.status = StatusContratacao.AGUARDANDO_ACEITE;
        }
    }
}