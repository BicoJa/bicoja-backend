package com.bicoja.bicoja.profissionalhabilidade;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfissionalHabilidadeService {

    private final ProfissionalHabilidadeRepository repository;

    public ProfissionalHabilidadeService(ProfissionalHabilidadeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ProfissionalHabilidadeEntity vincularHabilidade(ProfissionalHabilidadeDTO dto) {
        if (repository.existsByProfissionalIdAndHabilidadeId(dto.getProfissionalId(), dto.getHabilidadeId())) {
            throw new IllegalStateException("O profissional já possui esta habilidade vinculada.");
        }

        ProfissionalHabilidadeEntity vinculo = new ProfissionalHabilidadeEntity(
                dto.getProfissionalId(),
                dto.getHabilidadeId()
        );

        return repository.save(vinculo);
    }

    @Transactional(readOnly = true)
    public List<ProfissionalHabilidadeEntity> listarPorProfissional(Long profissionalId) {
        return repository.findByProfissionalId(profissionalId);
    }

    @Transactional(readOnly = true)
    public List<ProfissionalHabilidadeEntity> listarPorHabilidade(Long habilidadeId) {
        return repository.findByHabilidadeId(habilidadeId);
    }

    @Transactional
    public void desvincularHabilidade(Long profissionalId, Long habilidadeId) {
        if (!repository.existsByProfissionalIdAndHabilidadeId(profissionalId, habilidadeId)) {
            throw new IllegalArgumentException("Vínculo entre profissional e habilidade não encontrado.");
        }
        repository.deleteByProfissionalIdAndHabilidadeId(profissionalId, habilidadeId);
    }
}