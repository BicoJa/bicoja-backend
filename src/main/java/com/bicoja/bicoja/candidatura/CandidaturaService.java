package com.bicoja.bicoja.candidatura;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CandidaturaService {

    private final CandidaturaRepository repository;

    public CandidaturaService(CandidaturaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CandidaturaEntity aplicarParaVaga(CandidaturaDTO dto) {
        if (repository.existsByVagaIdAndProfissionalId(dto.getVagaId(), dto.getProfissionalId())) {
            throw new IllegalStateException("O profissional já se candidatou a esta vaga.");
        }

        CandidaturaEntity candidatura = new CandidaturaEntity(dto.getVagaId(), dto.getProfissionalId());
        return repository.save(candidatura);
    }

    @Transactional(readOnly = true)
    public List<CandidaturaEntity> listarPorVaga(Long vagaId) {
        return repository.findByVagaId(vagaId);
    }

    @Transactional(readOnly = true)
    public List<CandidaturaEntity> listarPorProfissional(Long profissionalId) {
        return repository.findByProfissionalId(profissionalId);
    }

    @Transactional
    public CandidaturaEntity atualizarStatus(Long id, CandidaturaEntity.StatusCandidatura novoStatus) {
        CandidaturaEntity candidatura = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Candidatura não encontrada."));

        candidatura.setStatus(novoStatus);
        return repository.save(candidatura);
    }
}