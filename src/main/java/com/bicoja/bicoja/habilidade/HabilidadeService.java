package com.bicoja.bicoja.habilidade;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HabilidadeService {

    private final HabilidadeRepository repository;

    public HabilidadeService(HabilidadeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public HabilidadeEntity criarHabilidade(HabilidadeDTO dto) {
        if (repository.existsByNomeIgnoreCase(dto.getNome())) {
            throw new IllegalStateException("Já existe uma habilidade cadastrada com este nome.");
        }

        HabilidadeEntity habilidade = new HabilidadeEntity(
                dto.getNome(),
                dto.getDescricao(),
                dto.getIconeUrl()
        );

        return repository.save(habilidade);
    }

    @Transactional(readOnly = true)
    public List<HabilidadeEntity> listarTodas() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public HabilidadeEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Habilidade não encontrada."));
    }

    @Transactional
    public HabilidadeEntity atualizarHabilidade(Long id, HabilidadeDTO dto) {
        HabilidadeEntity habilidade = buscarPorId(id);

        habilidade.setNome(dto.getNome());
        habilidade.setDescricao(dto.getDescricao());
        habilidade.setIconeUrl(dto.getIconeUrl());

        return repository.save(habilidade);
    }

    @Transactional
    public void deletarHabilidade(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Habilidade não encontrada para remoção.");
        }
        repository.deleteById(id);
    }
}