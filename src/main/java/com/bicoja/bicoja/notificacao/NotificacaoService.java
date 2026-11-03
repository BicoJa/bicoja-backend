package com.bicoja.bicoja.notificacao;

import com.bicoja.bicoja.config.RecursoNaoEncontradoException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificacaoService {
    private final NotificacaoRepository repository;

    public NotificacaoService(NotificacaoRepository repository) {
        this.repository = repository;
    }

    public List<Notificacao> listar() { return repository.findAll(); }
    public Notificacao buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Notificacao não encontrado: " + id));
    }
    public Notificacao salvar(Notificacao entidade) { return repository.save(entidade); }
    public Notificacao atualizar(Long id, Notificacao entidade) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Notificacao não encontrado: " + id);
        return repository.save(entidade);
    }
    public void excluir(Long id) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Notificacao não encontrado: " + id);
        repository.deleteById(id);
    }
}
