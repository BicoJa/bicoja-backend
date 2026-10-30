package com.bicoja.bicoja.contratante;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContratanteService {

    private final ContratanteRepository contratanteRepository;

    public ContratanteService(ContratanteRepository contratanteRepository) {
        this.contratanteRepository = contratanteRepository;
    }

    public ContratanteEntity salvar(ContratanteEntity contratante) {
        return contratanteRepository.save(contratante);
    }

    public List<ContratanteEntity> listarTodos() {
        return contratanteRepository.findAll();
    }

    public ContratanteEntity buscarPorId(Long id) {
        return contratanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contratante não encontrado com o ID: " + id));
    }

    public void deletar(Long id) {
        ContratanteEntity contratante = buscarPorId(id);
        contratanteRepository.delete(contratante);
    }
}