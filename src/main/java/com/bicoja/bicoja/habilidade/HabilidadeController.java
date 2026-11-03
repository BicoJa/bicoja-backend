package com.bicoja.bicoja.habilidade;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/habilidade")
@CrossOrigin(origins = "*")
public class HabilidadeController {
    private final HabilidadeService service;

    public HabilidadeController(HabilidadeService service) { this.service = service; }

    @GetMapping
    public List<Habilidade> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Habilidade buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Habilidade criar(@Valid @RequestBody Habilidade entidade) { return service.salvar(entidade); }

    @PutMapping("/{id}")
    public Habilidade atualizar(@PathVariable Long id, @Valid @RequestBody Habilidade entidade) {
        entidade.setId(id);
        return service.atualizar(id, entidade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) { service.excluir(id); }
}
