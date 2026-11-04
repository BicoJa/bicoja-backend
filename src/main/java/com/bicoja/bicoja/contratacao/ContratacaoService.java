package com.bicoja.bicoja.contratacao;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bicoja.bicoja.contratacao.dto.ContratacaoResponseDTO;
import com.bicoja.bicoja.notificacao.NotificacaoService;

import lombok.RequiredArgsConstructor;
import com.bicoja.bicoja.vaga.VagaEntity;
import com.bicoja.bicoja.profissional.ProfissionalEntity;

@Service
@RequiredArgsConstructor
public class ContratacaoService {

    private final ContratacaoRepository contratacaoRepository;
    private final NotificacaoService notificacaoService;

    @Transactional
    public ContratacaoEntity criar(
            VagaEntity vaga,
            ProfissionalEntity profissional) {

        boolean existe = contratacaoRepository.existeContratacao(
                vaga.getId(),
                profissional.getId_usuario()
        );

        if (existe) {
            throw new RuntimeException(
                    "Já existe uma contratação para este profissional nesta vaga."
            );
        }

        ContratacaoEntity contratacao = new ContratacaoEntity();

        contratacao.setVaga(vaga);
        contratacao.setProfissional(profissional);
        contratacao.setStatus(StatusContratacao.AGUARDANDO_ACEITE);

        return contratacaoRepository.save(contratacao);
    }

    // Lista todas as contratações de um profissional
    @Transactional(readOnly = true)
    public List<ContratacaoResponseDTO> listarPorProfissional(Integer idUsuario) {

        return contratacaoRepository.buscarPorProfissional(idUsuario)
                .stream()
                .map(ContratacaoResponseDTO::fromEntity)
                .toList();
    }

    // Lista as contratações de um profissional por status
    @Transactional(readOnly = true)
    public List<ContratacaoResponseDTO> listarPorProfissionalEStatus(
            Integer idUsuario,
            StatusContratacao status) {

        return contratacaoRepository.buscarPorProfissionalEStatus(idUsuario, status)
                .stream()
                .map(ContratacaoResponseDTO::fromEntity)
                .toList();
    }

    // Consulta uma contratação específica
    @Transactional(readOnly = true)
    public ContratacaoResponseDTO buscarPorId(Integer idContratacao, Integer idUsuario) {

        ContratacaoEntity contratacao = contratacaoRepository.findById(idContratacao)
                .orElseThrow(() -> new RuntimeException("Contratação não encontrada."));

        if (!contratacao.getProfissional().getId_usuario().equals(idUsuario)) {
            throw new RuntimeException("Você não tem permissão para visualizar esta contratação.");
        }

        return ContratacaoResponseDTO.fromEntity(contratacao);
    }

    // Profissional aceita ou recusa a contratação
    @Transactional
    public ContratacaoResponseDTO atualizarStatus(
            Integer idContratacao,
            Integer idUsuario,
            StatusContratacao novoStatus) {

        ContratacaoEntity contratacao = contratacaoRepository.findById(idContratacao)
                .orElseThrow(() -> new RuntimeException("Contratação não encontrada."));

        // Verifica se a contratação pertence ao profissional
        if (!contratacao.getProfissional().getId_usuario().equals(idUsuario)) {
            throw new RuntimeException("Você não tem permissão para alterar esta contratação.");
        }

        // Só permite decisão enquanto aguarda aceite
        if (contratacao.getStatus() != StatusContratacao.AGUARDANDO_ACEITE) {
            throw new RuntimeException("Esta contratação já recebeu uma decisão.");
        }

        // Só permite ACEITA ou RECUSADA
        if (novoStatus != StatusContratacao.ACEITA
                && novoStatus != StatusContratacao.RECUSADA) {
            throw new RuntimeException("Status inválido. Utilize ACEITA ou RECUSADA.");
        }

        contratacao.setStatus(novoStatus);

        ContratacaoEntity salva = contratacaoRepository.save(contratacao);

        // Identifica o contratante através da vaga
        Integer idContratante = contratacao.getVaga()
                .getContratante()
                .getId_usuario();

        String mensagem;

        if (novoStatus == StatusContratacao.ACEITA) {
            mensagem = "O profissional "
                    + contratacao.getProfissional().getUsuario().getNome()
                    + " aceitou o contrato da vaga '"
                    + contratacao.getVaga().getTitulo() + "'.";
        } else {
            mensagem = "O profissional "
                    + contratacao.getProfissional().getUsuario().getNome()
                    + " recusou o contrato da vaga '"
                    + contratacao.getVaga().getTitulo() + "'.";
        }

        // Notifica o contratante
        notificacaoService.criar(idContratante, mensagem);

        return ContratacaoResponseDTO.fromEntity(salva);
    }
}