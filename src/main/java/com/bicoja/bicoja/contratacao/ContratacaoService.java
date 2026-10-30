package com.bicoja.bicoja.contratacao;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContratacaoService {

    private final ContratacaoRepository contratacaoRepository;

    public ContratacaoService(ContratacaoRepository contratacaoRepository) {
        this.contratacaoRepository = contratacaoRepository;
    }

    public ContratacaoEntity criarContratacao(ContratacaoEntity contratacao) {
        contratacao.setStatus("EM_ANDAMENTO");
        return contratacaoRepository.save(contratacao);
    }

    public List<ContratacaoEntity> listarPorProfissional(Long profissionalId) {
        return contratacaoRepository.findByProfissionalId(profissionalId);
    }

    public List<ContratacaoEntity> listarPorContratante(Long contratanteId) {
        return contratacaoRepository.findByContratanteId(contratanteId);
    }

    public ContratacaoEntity atualizarStatus(Long id, String novoStatus) {
        ContratacaoEntity contratacao = contratacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contratação não encontrada com o ID: " + id));

        contratacao.setStatus(novoStatus);
        return contratacaoRepository.save(contratacao);
    }
}