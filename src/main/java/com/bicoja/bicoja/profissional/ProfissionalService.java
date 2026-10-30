package com.bicoja.bicoja.profissional;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfissionalService {

    private final ProfissionalRepository profissionalRepository;

    public ProfissionalService(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    public ProfissionalEntity salvar(ProfissionalEntity profissional) {
        return profissionalRepository.save(profissional);
    }

    public List<ProfissionalEntity> listarTodos() {
        return profissionalRepository.findAll();
    }

    public ProfissionalEntity buscarPorId(Long id) {
        return profissionalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado com o ID: " + id));
    }

    public void deletar(Long id) {
        ProfissionalEntity profissional = buscarPorId(id);
        profissionalRepository.delete(profissional);
    }
}