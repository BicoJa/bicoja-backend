package com.bicoja.bicoja.avaliacao;

import com.bicoja.bicoja.config.RecursoNaoEncontradoException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AvaliacaoService {
    private final AvaliacaoRepository repository;

    public AvaliacaoService(AvaliacaoRepository repository) {
        this.repository = repository;
    }

    public List<Avaliacao> listar() { return repository.findAll(); }
    public Avaliacao buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Avaliacao não encontrado: " + id));
    }
    public Avaliacao salvar(Avaliacao entidade) { return repository.save(entidade); }
    public Avaliacao atualizar(Long id, Avaliacao entidade) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Avaliacao não encontrado: " + id);
        return repository.save(entidade);
    }
    public void excluir(Long id) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Avaliacao não encontrado: " + id);
        repository.deleteById(id);
    }
}
