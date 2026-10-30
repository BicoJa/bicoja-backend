package com.bicoja.bicoja.profissionalhabilidade;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfissionalHabilidadeService {

    private final ProfissionalHabilidadeRepository repository;

    public ProfissionalHabilidadeService(ProfissionalHabilidadeRepository repository) {
        this.repository = repository;
    }

    public ProfissionalHabilidadeEntity associar(ProfissionalHabilidadeEntity associacao) {
        return repository.save(associacao);
    }

    public List<ProfissionalHabilidadeEntity> listarPorProfissional(Long profissionalId) {
        return repository.findByProfissionalId(profissionalId);
    }

    public void desassociar(Long profissionalId, Long habilidadeId) {
        ProfissionalHabilidadeId id = new ProfissionalHabilidadeId(profissionalId, habilidadeId);
        if (!repository.existsById(id)) {
            throw new RuntimeException("Associação entre profissional e habilidade não encontrada.");
        }
        repository.deleteById(id);
    }
}