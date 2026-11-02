package com.bicoja.bicoja.usuario;

import com.bicoja.bicoja.config.RecursoNaoEncontradoException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listar() { return repository.findAll(); }
    public Usuario buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Usuario não encontrado: " + id));
    }
    public Usuario salvar(Usuario entidade) { return repository.save(entidade); }
    public Usuario atualizar(Long id, Usuario entidade) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Usuario não encontrado: " + id);
        return repository.save(entidade);
    }
    public void excluir(Long id) {
        if (!repository.existsById(id)) throw new RecursoNaoEncontradoException("Usuario não encontrado: " + id);
        repository.deleteById(id);
    }
}
