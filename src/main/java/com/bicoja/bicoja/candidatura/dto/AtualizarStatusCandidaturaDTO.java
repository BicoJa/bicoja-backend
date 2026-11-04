package com.bicoja.bicoja.candidatura.dto;

import com.bicoja.bicoja.candidatura.StatusCandidatura;

public record AtualizarStatusCandidaturaDTO(
        Integer idUsuario,
        StatusCandidatura status
) {}