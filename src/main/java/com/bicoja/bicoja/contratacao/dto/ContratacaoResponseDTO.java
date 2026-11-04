package com.bicoja.bicoja.contratacao.dto;

import java.time.LocalDateTime;

import com.bicoja.bicoja.contratacao.ContratacaoEntity;
import com.bicoja.bicoja.contratacao.StatusContratacao;

public record ContratacaoResponseDTO(
        Integer id,
        Integer idVaga,
        String tituloVaga,
        String nomeContratante,
        String telefoneContratante,
        Integer idProfissional,
        String nomeProfissional,
        StatusContratacao status,
        LocalDateTime dataContratacao
) {

    public static ContratacaoResponseDTO fromEntity(ContratacaoEntity contratacao) {
        return new ContratacaoResponseDTO(
                contratacao.getId(),
                contratacao.getVaga().getId(),
                contratacao.getVaga().getTitulo(),
                contratacao.getVaga().getContratante().getUsuario().getNome(),
                contratacao.getVaga().getContratante().getUsuario().getTelefone(),
                contratacao.getProfissional().getId_usuario(),
                contratacao.getProfissional().getUsuario().getNome(),
                contratacao.getStatus(),
                contratacao.getDataContratacao()
        );
    }
}