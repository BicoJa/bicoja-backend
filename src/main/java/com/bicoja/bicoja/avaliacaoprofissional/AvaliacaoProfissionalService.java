package com.bicoja.bicoja.avaliacaoprofissional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bicoja.bicoja.avaliacaoprofissional.dto.AvaliacaoProfissionalRequestDTO;
import com.bicoja.bicoja.avaliacaoprofissional.dto.AvaliacaoProfissionalResponseDTO;
import com.bicoja.bicoja.contratacao.ContratacaoEntity;
import com.bicoja.bicoja.contratacao.ContratacaoRepository;
import com.bicoja.bicoja.contratacao.StatusContratacao;
import com.bicoja.bicoja.usuario.UsuarioEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvaliacaoProfissionalService {

    private final AvaliacaoProfissionalRepository avaliacaoRepository;
    private final ContratacaoRepository contratacaoRepository;

    @Transactional
    public AvaliacaoProfissionalResponseDTO avaliar(
            Integer idContratacao,
            Integer idUsuario,
            AvaliacaoProfissionalRequestDTO dados) {

        // Validar nota
        if (dados.nota() == null || dados.nota() < 1 || dados.nota() > 5) {
            throw new RuntimeException("A nota deve estar entre 1 e 5.");
        }

        // Buscar contratação
        ContratacaoEntity contratacao = contratacaoRepository.findById(idContratacao)
                .orElseThrow(() -> new RuntimeException("Contratação não encontrada."));

        // Verificar se o usuário é o contratante dono da vaga
        Integer idContratante = contratacao.getVaga()
                .getContratante().getId_usuario();

        if (!idContratante.equals(idUsuario)) {
            throw new RuntimeException("Você não tem permissão para avaliar este profissional.");
        }

        // Verificar se a contratação foi aceita
        if (contratacao.getStatus() != StatusContratacao.ACEITA) {
            throw new RuntimeException("Só é possível avaliar após o profissional aceitar o contrato.");
        }

        // Impedir avaliação duplicada
        if (avaliacaoRepository.existsByContratacao_Id(idContratacao)) {
            throw new RuntimeException("Esta contratação já possui uma avaliação.");
        }

        // Obter o contratante como avaliador
        UsuarioEntity avaliador = contratacao.getVaga()
                .getContratante().getUsuario();

        // Criar avaliação
        AvaliacaoProfissionalEntity avaliacao = new AvaliacaoProfissionalEntity();
        avaliacao.setContratacao(contratacao);
        avaliacao.setAvaliador(avaliador);
        avaliacao.setProfissional(contratacao.getProfissional());
        avaliacao.setNota(dados.nota());
        avaliacao.setComentario(dados.comentario());

        AvaliacaoProfissionalEntity salva = avaliacaoRepository.save(avaliacao);

        // Recalcular média do profissional
        atualizarMedia(contratacao.getProfissional().getId_usuario());

        return AvaliacaoProfissionalResponseDTO.fromEntity(salva);
    }

    private void atualizarMedia(Integer idProfissional) {

        List<AvaliacaoProfissionalEntity> avaliacoes =
                avaliacaoRepository.buscarPorProfissional(idProfissional);

        BigDecimal soma = avaliacoes.stream()
                .map(avaliacao -> BigDecimal.valueOf(avaliacao.getNota()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal media = soma.divide(
                BigDecimal.valueOf(avaliacoes.size()),
                1,
                RoundingMode.HALF_UP
        );

        var profissional = avaliacoes.get(0).getProfissional();
        profissional.setAvaliacao(media);
    }
}