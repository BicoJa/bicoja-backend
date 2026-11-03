package com.bicoja.bicoja.vaga;

import com.bicoja.bicoja.contratante.ContratanteEntity;
import com.bicoja.bicoja.habilidade.HabilidadeEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.bicoja.bicoja.endereco.Endereco;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "VAGA")
public class VagaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contratante", nullable = false)
    private ContratanteEntity contratante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_habilidade", nullable = false)
    private HabilidadeEntity habilidade;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, length = 1000)
    private String descricao;

    @Embedded
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusVaga status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();

        if (this.status == null) {
            this.status = StatusVaga.ABERTA;
        }
    }

    @Column
    private LocalDateTime dataConclusao;

    @Column
    private LocalDateTime dataCancelamento;
}