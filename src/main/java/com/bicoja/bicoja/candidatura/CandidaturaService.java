package com.bicoja.bicoja.candidatura;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CandidaturaService {

    private final CandidaturaRepository candidaturaRepository;

    public CandidaturaService(CandidaturaRepository candidaturaRepository) {
        this.candidaturaRepository = candidaturaRepository;
    }

    public CandidaturaEntity realizarCandidatura(CandidaturaEntity candidatura) {
        candidatura.setStatus("PENDENTE");
        return candidaturaRepository.save(candidatura);
    }

    public List<CandidaturaEntity> listarPorVaga(Long vagaId) {
        return candidaturaRepository.findByVagaId(vagaId);
    }

    public List<CandidaturaEntity> listarPorProfissional(Long profissionalId) {
        return candidaturaRepository.findByProfissionalId(profissionalId);
    }

    public CandidaturaEntity atualizarStatus(Long id, String novoStatus) {
        CandidaturaEntity candidatura = candidaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidatura não encontrada com o ID: " + id));

        candidatura.setStatus(novoStatus);
        return candidaturaRepository.save(candidatura);
    }
}