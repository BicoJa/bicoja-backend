package com.bicoja.bicoja.habilidade;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HabilidadeService {

    private final HabilidadeRepository habilidadeRepository;

    public HabilidadeService(HabilidadeRepository habilidadeRepository) {
        this.habilidadeRepository = habilidadeRepository;
    }

    public HabilidadeEntity criarHabilidade(HabilidadeEntity habilidade) {
        if (habilidadeRepository.existsByNome(habilidade.getNome())) {
            throw new RuntimeException("Esta habilidade já se encontra cadastrada.");
        }
        return habilidadeRepository.save(habilidade);
    }

    public List<HabilidadeEntity> listarTodas() {
        return habilidadeRepository.findAll();
    }

    public HabilidadeEntity buscarPorId(Long id) {
        return habilidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habilidade não encontrada com o ID: " + id));
    }

    public void deletarHabilidade(Long id) {
        HabilidadeEntity habilidade = buscarPorId(id);
        habilidadeRepository.delete(habilidade);
    }
}