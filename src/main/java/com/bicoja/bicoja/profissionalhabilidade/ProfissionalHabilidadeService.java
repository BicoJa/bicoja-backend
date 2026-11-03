package com.bicoja.bicoja.profissionalhabilidade;

import com.bicoja.bicoja.config.RecursoNaoEncontradoException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfissionalHabilidadeService {
    private final ProfissionalHabilidadeRepository repository;

    public ProfissionalHabilidadeService(ProfissionalHabilidadeRepository repository) {
        this.repository = repository;
    }

    public List<ProfissionalHabilidade> listar() { return repository.findAll(); }
    public ProfissionalHabilidade buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("ProfissionalHabilidade não encontrado: " + id));
    }
    public ProfissionalHabilidade salvar(ProfissionalHabilidade entidade) { return repository.save(entidade); }
    public ProfissionalHabilidade atualizar(Long id, ProfissionalHabilidade entidade) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("ProfissionalHabilidade não encontrado: " + id);
        return repository.save(entidade);
    }
    public void excluir(Long id) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("ProfissionalHabilidade não encontrado: " + id);
        repository.deleteById(id);
    }
}
