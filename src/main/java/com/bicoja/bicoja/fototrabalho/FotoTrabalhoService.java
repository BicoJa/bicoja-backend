package com.bicoja.bicoja.fototrabalho;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FotoTrabalhoService {

    private final FotoTrabalhoRepository fotoTrabalhoRepository;

    public FotoTrabalhoService(FotoTrabalhoRepository fotoTrabalhoRepository) {
        this.fotoTrabalhoRepository = fotoTrabalhoRepository;
    }

    public FotoTrabalhoEntity salvar(FotoTrabalhoEntity foto) {
        return fotoTrabalhoRepository.save(foto);
    }

    public List<FotoTrabalhoEntity> listarPorProfissional(Long profissionalId) {
        return fotoTrabalhoRepository.findByProfissionalId(profissionalId);
    }

    public void deletar(Long id) {
        FotoTrabalhoEntity foto = fotoTrabalhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foto não encontrada com o ID: " + id));
        fotoTrabalhoRepository.delete(foto);
    }
}