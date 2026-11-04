package com.bicoja.bicoja.candidatura;

import java.util.List;

import com.bicoja.bicoja.contratacao.ContratacaoService;
import com.bicoja.bicoja.notificacao.NotificacaoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bicoja.bicoja.candidatura.dto.CandidaturaResponseDTO;
import com.bicoja.bicoja.profissional.ProfissionalEntity;
import com.bicoja.bicoja.profissional.ProfissionalRepository;
import com.bicoja.bicoja.vaga.VagaEntity;
import com.bicoja.bicoja.vaga.VagaRepository;
import com.bicoja.bicoja.vaga.StatusVaga;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidaturaService {

    private final CandidaturaRepository candidaturaRepository;
    private final ProfissionalRepository profissionalRepository;
    private final VagaRepository vagaRepository;
    private final NotificacaoService notificacaoService;
    private final ContratacaoService contratacaoService;

    // Criar candidatura
    public CandidaturaResponseDTO criar(Integer idVaga, Integer idUsuario) {

        VagaEntity vaga = vagaRepository.findById(idVaga)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada."));

        ProfissionalEntity profissional = profissionalRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado."));

        if (vaga.getStatus() != StatusVaga.ABERTA) {
            throw new RuntimeException(
                    "Não é possível se candidatar a uma vaga que não está aberta."
            );
        }

        if (candidaturaRepository.existeCandidatura(idVaga, idUsuario)) {
            throw new RuntimeException("Você já se candidatou a esta vaga.");
        }

        CandidaturaEntity candidatura = new CandidaturaEntity();

        candidatura.setVaga(vaga);
        candidatura.setProfissional(profissional);
        candidatura.setStatus(StatusCandidatura.PENDENTE);

        CandidaturaEntity salva = candidaturaRepository.save(candidatura);

        notificacaoService.criar(
                vaga.getContratante().getId_usuario(),
                profissional.getUsuario().getNome()
                        + " se candidatou à sua vaga: "
                        + vaga.getTitulo()
        );

        return CandidaturaResponseDTO.fromEntity(salva);
    }

    // Listar candidaturas de um profissional
    public List<CandidaturaResponseDTO> listarPorProfissional(Integer idUsuario) {

        return candidaturaRepository.buscarPorProfissional(idUsuario)
                .stream()
                .map(CandidaturaResponseDTO::fromEntity)
                .toList();
    }

    // Listar profissionais que se candidataram a uma vaga
    public List<CandidaturaResponseDTO> listarPorVaga(Integer idVaga) {

        return candidaturaRepository.findByVaga_Id(idVaga)
                .stream()
                .map(CandidaturaResponseDTO::fromEntity)
                .toList();
    }

    // Aceitar ou recusar candidatura
    @Transactional
    public CandidaturaResponseDTO atualizarStatus(
            Integer idCandidatura,
            Integer idUsuario,
            StatusCandidatura novoStatus) {

        CandidaturaEntity candidatura = candidaturaRepository.findById(idCandidatura)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada."));

        if (!candidatura.getVaga().getContratante().getId_usuario().equals(idUsuario)) {
            throw new RuntimeException("Você não tem permissão para alterar esta candidatura.");
        }

        if (candidatura.getStatus() != StatusCandidatura.PENDENTE) {
            throw new RuntimeException("Esta candidatura já foi respondida.");
        }

        if (novoStatus != StatusCandidatura.ACEITA &&
                novoStatus != StatusCandidatura.RECUSADA) {

            throw new RuntimeException("Status inválido. Utilize ACEITA ou RECUSADA.");
        }

        candidatura.setStatus(novoStatus);

        CandidaturaEntity salva = candidaturaRepository.save(candidatura);

        String mensagem;

        if (novoStatus == StatusCandidatura.ACEITA) {

            // Cria a contratação aguardando a decisão do profissional
            contratacaoService.criar(
                    candidatura.getVaga(),
                    candidatura.getProfissional()
            );

            mensagem = "Sua candidatura para a vaga '"
                    + candidatura.getVaga().getTitulo()
                    + "' foi aceita! Você tem um contrato aguardando sua aprovação.";

        } else {

            // Recusa não gera contratação
            mensagem = "Sua candidatura para a vaga '"
                    + candidatura.getVaga().getTitulo()
                    + "' foi recusada.";
        }

        notificacaoService.criar(
                candidatura.getProfissional().getId_usuario(),
                mensagem
        );

        return CandidaturaResponseDTO.fromEntity(salva);
    }

    // Buscar candidaturas de um profissional por status
    public List<CandidaturaResponseDTO> listarPorProfissionalEStatus(
            Integer idUsuario,
            StatusCandidatura status) {

        return candidaturaRepository
                .buscarPorProfissionalEStatus(idUsuario, status)
                .stream()
                .map(CandidaturaResponseDTO::fromEntity)
                .toList();
    }

    // Cancelar candidatura pelo profissional
    public CandidaturaResponseDTO cancelar(
            Integer idCandidatura,
            Integer idUsuario) {

        CandidaturaEntity candidatura = candidaturaRepository.findById(idCandidatura)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada."));

        if (!candidatura.getProfissional().getId_usuario().equals(idUsuario)) {
            throw new RuntimeException("Você não tem permissão para cancelar esta candidatura.");
        }

        if (candidatura.getStatus() != StatusCandidatura.PENDENTE) {
            throw new RuntimeException("Somente candidaturas pendentes podem ser canceladas.");
        }

        candidatura.setStatus(StatusCandidatura.CANCELADA);

        CandidaturaEntity salva = candidaturaRepository.save(candidatura);

        return CandidaturaResponseDTO.fromEntity(salva);
    }

    // Buscar candidaturas de uma vaga por status
    public List<CandidaturaResponseDTO> listarPorVagaEStatus(
            Integer idVaga,
            StatusCandidatura status) {

        return candidaturaRepository
                .buscarPorVagaEStatus(idVaga, status)
                .stream()
                .map(CandidaturaResponseDTO::fromEntity)
                .toList();
    }
}