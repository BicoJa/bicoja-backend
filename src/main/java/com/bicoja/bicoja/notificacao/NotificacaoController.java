package com.bicoja.bicoja.notificacao;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notificacao")
@CrossOrigin(origins = "*")
public class NotificacaoController {
    private final NotificacaoService service;

    public NotificacaoController(NotificacaoService service) { this.service = service; }

    @GetMapping
    public List<Notificacao> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Notificacao buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Notificacao criar(@Valid @RequestBody Notificacao entidade) { return service.salvar(entidade); }

    @PutMapping("/{id}")
    public Notificacao atualizar(@PathVariable Long id, @Valid @RequestBody Notificacao entidade) {
        entidade.setId(id);
        return service.atualizar(id, entidade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) { service.excluir(id); }
}
