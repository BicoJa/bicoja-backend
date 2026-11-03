package com.bicoja.bicoja.contratacao;

import com.bicoja.bicoja.config.RecursoNaoEncontradoException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContratacaoService {
    private final ContratacaoRepository repository;

    public ContratacaoService(ContratacaoRepository repository) {
        this.repository = repository;
    }

    public List<Contratacao> listar() { return repository.findAll(); }
    public Contratacao buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Contratacao não encontrado: " + id));
    }
    public Contratacao salvar(Contratacao entidade) { return repository.save(entidade); }
    public Contratacao atualizar(Long id, Contratacao entidade) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Contratacao não encontrado: " + id);
        return repository.save(entidade);
    }
    public void excluir(Long id) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Contratacao não encontrado: " + id);
        repository.deleteById(id);
    }
}
