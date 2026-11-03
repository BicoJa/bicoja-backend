package com.bicoja.bicoja.candidatura;

import com.bicoja.bicoja.config.RecursoNaoEncontradoException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CandidaturaService {
    private final CandidaturaRepository repository;

    public CandidaturaService(CandidaturaRepository repository) {
        this.repository = repository;
    }

    public List<Candidatura> listar() { return repository.findAll(); }
    public Candidatura buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Candidatura não encontrado: " + id));
    }
    public Candidatura salvar(Candidatura entidade) { return repository.save(entidade); }
    public Candidatura atualizar(Long id, Candidatura entidade) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Candidatura não encontrado: " + id);
        return repository.save(entidade);
    }
    public void excluir(Long id) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Candidatura não encontrado: " + id);
        repository.deleteById(id);
    }
}
