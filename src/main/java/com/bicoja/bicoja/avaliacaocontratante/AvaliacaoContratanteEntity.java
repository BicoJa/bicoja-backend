package com.bicoja.bicoja.avaliacaocontratante;

import com.bicoja.bicoja.contratacao.ContratacaoEntity;
import com.bicoja.bicoja.contratante.ContratanteEntity;
import com.bicoja.bicoja.usuario.UsuarioEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "AVALIACAO_CONTRATANTE")
public class AvaliacaoContratanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_contratacao", nullable = false)
    private ContratacaoEntity contratacao;

    @ManyToOne
    @JoinColumn(name = "id_avaliador", nullable = false)
    private UsuarioEntity avaliador;

    @ManyToOne
    @JoinColumn(name = "id_contratante", nullable = false)
    private ContratanteEntity contratante;

    public AvaliacaoContratanteEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ContratacaoEntity getContratacao() {
        return contratacao;
    }

    public void setContratacao(ContratacaoEntity contratacao) {
        this.contratacao = contratacao;
    }

    public UsuarioEntity getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(UsuarioEntity avaliador) {
        this.avaliador = avaliador;
    }

    public ContratanteEntity getContratante() {
        return contratante;
    }

    public void setContratante(ContratanteEntity contratante) {
        this.contratante = contratante;
    }

}
