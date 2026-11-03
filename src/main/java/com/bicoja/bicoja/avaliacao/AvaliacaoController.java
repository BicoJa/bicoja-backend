package com.bicoja.bicoja.avaliacao;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/avaliacao")
@CrossOrigin(origins = "*")
public class AvaliacaoController {
    private final AvaliacaoService service;

    public AvaliacaoController(AvaliacaoService service) { this.service = service; }

    @GetMapping
    public List<Avaliacao> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Avaliacao buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Avaliacao criar(@Valid @RequestBody Avaliacao entidade) { return service.salvar(entidade); }

    @PutMapping("/{id}")
    public Avaliacao atualizar(@PathVariable Long id, @Valid @RequestBody Avaliacao entidade) {
        entidade.setId(id);
        return service.atualizar(id, entidade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) { service.excluir(id); }
}
