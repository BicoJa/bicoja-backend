/*package com.bicoja.bicoja.avaliacaocontratante;

import com.bicoja.bicoja.contratacao.ContratacaoEntity;
import com.bicoja.bicoja.contratante.ContratanteEntity;
import com.bicoja.bicoja.usuario.UsuarioEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "AVALIACAO_CONTRATANTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}*/

