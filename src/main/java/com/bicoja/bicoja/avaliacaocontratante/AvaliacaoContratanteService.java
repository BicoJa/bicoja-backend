package com.bicoja.bicoja.avaliacaocontratante;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AvaliacaoContratanteService {

    private final AvaliacaoContratanteRepository repository;

    public AvaliacaoContratanteService(AvaliacaoContratanteRepository repository) {
        this.repository = repository;
    }

    public AvaliacaoContratanteEntity criarAvaliacao(AvaliacaoContratanteEntity avaliacao) {
        return repository.save(avaliacao);
    }

    public List<AvaliacaoContratanteEntity> listarPorContratante(Long contratanteId) {
        return repository.findByContratanteId(contratanteId);
    }
}