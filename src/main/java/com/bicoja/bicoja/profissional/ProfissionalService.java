package com.bicoja.bicoja.profissional;

import com.bicoja.bicoja.config.RecursoNaoEncontradoException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfissionalService {
    private final ProfissionalRepository repository;

    public ProfissionalService(ProfissionalRepository repository) {
        this.repository = repository;
    }

    public List<Profissional> listar() { return repository.findAll(); }
    public Profissional buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Profissional não encontrado: " + id));
    }
    public Profissional salvar(Profissional entidade) { return repository.save(entidade); }
    public Profissional atualizar(Long id, Profissional entidade) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Profissional não encontrado: " + id);
        return repository.save(entidade);
    }
    public void excluir(Long id) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Profissional não encontrado: " + id);
        repository.deleteById(id);
    }
}
