package com.bicoja.bicoja.contratacao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContratacaoService {

    private final ContratacaoRepository repository;

    public ContratacaoService(ContratacaoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ContratacaoEntity criarContratacao(ContratacaoDTO dto) {
        if (repository.existsByVagaIdAndStatus(dto.getVagaId(), ContratacaoEntity.StatusContratacao.EM_ANDAMENTO)) {
            throw new IllegalStateException("Esta vaga já possui uma contratação ativa.");
        }

        ContratacaoEntity contratacao = new ContratacaoEntity(
                dto.getVagaId(),
                dto.getContratanteId(),
                dto.getProfissionalId(),
                dto.getValorAcordado()
        );

        return repository.save(contratacao);
    }

    @Transactional(readOnly = true)
    public List<ContratacaoEntity> listarPorContratante(Long contratanteId) {
        return repository.findByContratanteId(contratanteId);
    }

    @Transactional(readOnly = true)
    public List<ContratacaoEntity> listarPorProfissional(Long profissionalId) {
        return repository.findByProfissionalId(profissionalId);
    }

    @Transactional
    public ContratacaoEntity atualizarStatus(Long id, ContratacaoEntity.StatusContratacao novoStatus) {
        ContratacaoEntity contratacao = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contratação não encontrada."));

        contratacao.setStatus(novoStatus);

        if (novoStatus == ContratacaoEntity.StatusContratacao.CONCLUIDA || novoStatus == ContratacaoEntity.StatusContratacao.CANCELADA) {
            contratacao.setDataConclusao(LocalDateTime.now());
        }

        return repository.save(contratacao);
    }
}