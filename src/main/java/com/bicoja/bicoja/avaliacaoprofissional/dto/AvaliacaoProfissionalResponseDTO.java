package com.bicoja.bicoja.avaliacaoprofissional.dto;

import com.bicoja.bicoja.avaliacaoprofissional.AvaliacaoProfissionalEntity;

public record AvaliacaoProfissionalResponseDTO(
        Integer id,
        Integer idContratacao,
        Integer idAvaliador,
        String nomeAvaliador,
        Integer idProfissional,
        String nomeProfissional,
        Integer nota,
        String comentario
) {

    public static AvaliacaoProfissionalResponseDTO fromEntity(
            AvaliacaoProfissionalEntity avaliacao) {

        return new AvaliacaoProfissionalResponseDTO(
                avaliacao.getId(),
                avaliacao.getContratacao().getId(),
                avaliacao.getAvaliador().getId_usuario(),
                avaliacao.getAvaliador().getNome(),
                avaliacao.getProfissional().getId_usuario(),
                avaliacao.getProfissional().getUsuario().getNome(),
                avaliacao.getNota(),
                avaliacao.getComentario()
        );
    }
}