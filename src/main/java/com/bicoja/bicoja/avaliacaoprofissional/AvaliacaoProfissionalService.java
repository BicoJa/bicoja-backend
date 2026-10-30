package com.bicoja.bicoja.avaliacaoprofissional;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AvaliacaoProfissionalService {

    private final AvaliacaoProfissionalRepository repository;

    public AvaliacaoProfissionalService(AvaliacaoProfissionalRepository repository) {
        this.repository = repository;
    }

    public AvaliacaoProfissionalEntity salvarAvaliacao(AvaliacaoProfissionalDTO dto) {
        AvaliacaoProfissionalEntity avaliacao = new AvaliacaoProfissionalEntity(
                dto.getProfissionalId(),
                dto.getContratanteId(),
                dto.getNota(),
                dto.getComentario()
        );
        return repository.save(avaliacao);
    }

    public List<AvaliacaoProfissionalEntity> listarPorProfissional(Long profissionalId) {
        return repository.findByProfissionalId(profissionalId);
    }
}