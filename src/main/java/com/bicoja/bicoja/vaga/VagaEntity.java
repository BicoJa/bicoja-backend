package com.bicoja.bicoja.vaga;

import com.bicoja.bicoja.contratante.ContratanteEntity;
import com.bicoja.bicoja.habilidade.HabilidadeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "VAGA")
public class VagaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_contratante", nullable = false)
    private ContratanteEntity contratante;

    @ManyToOne
    @JoinColumn(name = "id_habilidade", nullable = false)
    private HabilidadeEntity habilidade;

    public VagaEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ContratanteEntity getContratante() {
        return contratante;
    }

    public void setContratante(ContratanteEntity contratante) {
        this.contratante = contratante;
    }

    public HabilidadeEntity getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(HabilidadeEntity habilidade) {
        this.habilidade = habilidade;
    }

}
