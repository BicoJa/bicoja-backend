package com.bicoja.bicoja.contratante;

import com.bicoja.bicoja.config.RecursoNaoEncontradoException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContratanteService {
    private final ContratanteRepository repository;

    public ContratanteService(ContratanteRepository repository) {
        this.repository = repository;
    }

    public List<Contratante> listar() { return repository.findAll(); }
    public Contratante buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Contratante não encontrado: " + id));
    }
    public Contratante salvar(Contratante entidade) { return repository.save(entidade); }
    public Contratante atualizar(Long id, Contratante entidade) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Contratante não encontrado: " + id);
        return repository.save(entidade);
    }
    public void excluir(Long id) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Contratante não encontrado: " + id);
        repository.deleteById(id);
    }
}
