package com.bicoja.bicoja.avaliacaoprofissional;

import com.bicoja.bicoja.contratacao.ContratacaoEntity;
import com.bicoja.bicoja.profissional.ProfissionalEntity;
import com.bicoja.bicoja.usuario.UsuarioEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(
        name = "AVALIACAO_PROFISSIONAL",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id_contratacao")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoProfissionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contratacao", nullable = false)
    private ContratacaoEntity contratacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_avaliador", nullable = false)
    private UsuarioEntity avaliador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profissional", nullable = false)
    private ProfissionalEntity profissional;

    @Column(nullable = false)
    private Integer nota;

    @Column(length = 500)
    private String comentario;
}