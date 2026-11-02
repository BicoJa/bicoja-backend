package com.bicoja.bicoja.contratacao;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contratacao")
@CrossOrigin(origins = "*")
public class ContratacaoController {
    private final ContratacaoService service;

    public ContratacaoController(ContratacaoService service) { this.service = service; }

    @GetMapping
    public List<Contratacao> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Contratacao buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contratacao criar(@Valid @RequestBody Contratacao entidade) { return service.salvar(entidade); }

    @PutMapping("/{id}")
    public Contratacao atualizar(@PathVariable Long id, @Valid @RequestBody Contratacao entidade) {
        entidade.setId(id);
        return service.atualizar(id, entidade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) { service.excluir(id); }
}
