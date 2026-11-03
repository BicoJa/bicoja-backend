package com.bicoja.bicoja.vaga.dto;

import com.bicoja.bicoja.endereco.Endereco;
import com.bicoja.bicoja.vaga.StatusVaga;
import com.bicoja.bicoja.vaga.VagaEntity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public record VagaResponseDTO(
        Integer id,
        String titulo,
        String descricao,
        String habilidade,
        Endereco endereco,
        StatusVaga status,
        String tempoPublicacao,
        String nomeContratante,
        String telefoneContratante,
        String tempoEncerramento,
        String tempoCancelamento
) {

    public static VagaResponseDTO fromEntity(VagaEntity vaga) {
        return new VagaResponseDTO(
                vaga.getId(),
                vaga.getTitulo(),
                vaga.getDescricao(),
                vaga.getHabilidade().getNome(),
                vaga.getEndereco(),
                vaga.getStatus(),
                calcularTempoPublicacao(vaga.getDataCriacao()),
                vaga.getContratante().getUsuario().getNome(),
                vaga.getContratante().getUsuario().getTelefone(),
                calcularTempoPublicacao(vaga.getDataConclusao()),
                calcularTempoPublicacao(vaga.getDataCancelamento())
        );
    }

    private static String calcularTempoPublicacao(LocalDateTime dataCriacao) {

        if (dataCriacao == null) { return null; }

        LocalDateTime agora = LocalDateTime.now();

        long anos = ChronoUnit.YEARS.between(dataCriacao, agora);
        if (anos > 0) return "há " + anos + (anos == 1 ? " ano" : " anos");

        long meses = ChronoUnit.MONTHS.between(dataCriacao, agora);
        if (meses > 0) return "há " + meses + (meses == 1 ? " mês" : " meses");

        long dias = ChronoUnit.DAYS.between(dataCriacao, agora);
        if (dias > 0) return "há " + dias + (dias == 1 ? " dia" : " dias");

        long horas = ChronoUnit.HOURS.between(dataCriacao, agora);
        if (horas > 0) return "há " + horas + (horas == 1 ? " hora" : " horas");

        long minutos = ChronoUnit.MINUTES.between(dataCriacao, agora);
        if (minutos > 0) return "há " + minutos + (minutos == 1 ? " minuto" : " minutos");

        return "há poucos segundos";
    }
}