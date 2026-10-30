package com.bicoja.bicoja.fototrabalho;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FotoTrabalhoService {

    private final FotoTrabalhoRepository repository;

    public FotoTrabalhoService(FotoTrabalhoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public FotoTrabalhoEntity adicionarFoto(FotoTrabalhoDTO dto) {
        FotoTrabalhoEntity foto = new FotoTrabalhoEntity(
                dto.getProfissionalId(),
                dto.getUrlFoto(),
                dto.getDescricao()
        );
        return repository.save(foto);
    }

    @Transactional(readOnly = true)
    public List<FotoTrabalhoEntity> listarPorProfissional(Long profissionalId) {
        return repository.findByProfissionalId(profissionalId);
    }

    @Transactional(readOnly = true)
    public FotoTrabalhoEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Foto de trabalho não encontrada."));
    }

    @Transactional
    public void removerFoto(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Foto de trabalho não encontrada para remoção.");
        }
        repository.deleteById(id);
    }
}