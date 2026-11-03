package com.bicoja.bicoja.candidatura;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/candidatura")
@CrossOrigin(origins = "*")
public class CandidaturaController {
    private final CandidaturaService service;

    public CandidaturaController(CandidaturaService service) { this.service = service; }

    @GetMapping
    public List<Candidatura> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Candidatura buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Candidatura criar(@Valid @RequestBody Candidatura entidade) { return service.salvar(entidade); }

    @PutMapping("/{id}")
    public Candidatura atualizar(@PathVariable Long id, @Valid @RequestBody Candidatura entidade) {
        entidade.setId(id);
        return service.atualizar(id, entidade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) { service.excluir(id); }
}
