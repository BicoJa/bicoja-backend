package com.bicoja.bicoja.vaga;

import com.bicoja.bicoja.config.RecursoNaoEncontradoException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VagaService {
    private final VagaRepository repository;

    public VagaService(VagaRepository repository) {
        this.repository = repository;
    }

    public List<Vaga> listar() { return repository.findAll(); }
    public Vaga buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Vaga não encontrado: " + id));
    }
    public Vaga salvar(Vaga entidade) { return repository.save(entidade); }
    public Vaga atualizar(Long id, Vaga entidade) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Vaga não encontrado: " + id);
        return repository.save(entidade);
    }
    public void excluir(Long id) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Vaga não encontrado: " + id);
        repository.deleteById(id);
    }
}
