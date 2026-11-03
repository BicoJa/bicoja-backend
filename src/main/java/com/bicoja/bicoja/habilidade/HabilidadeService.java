package com.bicoja.bicoja.habilidade;

import com.bicoja.bicoja.config.RecursoNaoEncontradoException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HabilidadeService {
    private final HabilidadeRepository repository;

    public HabilidadeService(HabilidadeRepository repository) {
        this.repository = repository;
    }

    public List<Habilidade> listar() { return repository.findAll(); }
    public Habilidade buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Habilidade não encontrado: " + id));
    }
    public Habilidade salvar(Habilidade entidade) { return repository.save(entidade); }
    public Habilidade atualizar(Long id, Habilidade entidade) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Habilidade não encontrado: " + id);
        return repository.save(entidade);
    }
    public void excluir(Long id) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Habilidade não encontrado: " + id);
        repository.deleteById(id);
    }
}
