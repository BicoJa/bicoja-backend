package com.bicoja.bicoja.avaliacaoprofissional;

import com.bicoja.bicoja.contratacao.ContratacaoEntity;
import com.bicoja.bicoja.profissional.ProfissionalEntity;
import com.bicoja.bicoja.usuario.UsuarioEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "AVALIACAO_PROFISSIONAL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoProfissionalEntity {

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
    @JoinColumn(name = "id_profissional", nullable = false)
    private ProfissionalEntity profissional;

}
