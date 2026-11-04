package com.bicoja.bicoja.candidatura.dto;

import java.math.BigDecimal;

import com.bicoja.bicoja.candidatura.CandidaturaEntity;
import com.bicoja.bicoja.candidatura.StatusCandidatura;

public record CandidaturaResponseDTO(
        Integer id,
        Integer idVaga,
        Integer idProfissional,
        String nomeProfissional,
        BigDecimal avaliacao,
        StatusCandidatura status
) {

    public static CandidaturaResponseDTO fromEntity(CandidaturaEntity candidatura) {
        return new CandidaturaResponseDTO(
                candidatura.getId(),
                candidatura.getVaga().getId(),
                candidatura.getProfissional().getId_usuario(),
                candidatura.getProfissional().getUsuario().getNome(),
                candidatura.getProfissional().getAvaliacao(),
                candidatura.getStatus()
        );
    }
}