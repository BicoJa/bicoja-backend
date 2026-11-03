package com.bicoja.bicoja.vaga.dto;

import com.bicoja.bicoja.endereco.Endereco;

public record VagaRequestDTO(
        Integer idUsuario,
        String habilidade,
        String titulo,
        String descricao,
        Endereco endereco
) {
}