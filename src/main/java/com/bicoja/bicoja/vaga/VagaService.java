package com.bicoja.bicoja.vaga;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VagaService {

    private final VagaRepository vagaRepository;

    public VagaService(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    public VagaEntity publicarVaga(VagaEntity vaga) {
        vaga.setStatus("ABERTA");
        return vagaRepository.save(vaga);
    }

    public List<VagaEntity> listarVagasAbertas() {
        return vagaRepository.findByStatus("ABERTA");
    }

    public VagaEntity buscarPorId(Long id) {
        return vagaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada com o ID: " + id));
    }

    public void deletarVaga(Long id) {
        VagaEntity vaga = buscarPorId(id);
        vagaRepository.delete(vaga);
    }
}