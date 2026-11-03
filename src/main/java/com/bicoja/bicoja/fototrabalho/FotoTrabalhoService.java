package com.bicoja.bicoja.fototrabalho;

import com.bicoja.bicoja.config.RecursoNaoEncontradoException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FotoTrabalhoService {
    private final FotoTrabalhoRepository repository;

    public FotoTrabalhoService(FotoTrabalhoRepository repository) {
        this.repository = repository;
    }

    public List<FotoTrabalho> listar() { return repository.findAll(); }
    public FotoTrabalho buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("FotoTrabalho não encontrado: " + id));
    }
    public FotoTrabalho salvar(FotoTrabalho entidade) { return repository.save(entidade); }
    public FotoTrabalho atualizar(Long id, FotoTrabalho entidade) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("FotoTrabalho não encontrado: " + id);
        return repository.save(entidade);
    }
    public void excluir(Long id) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("FotoTrabalho não encontrado: " + id);
        repository.deleteById(id);
    }
}
