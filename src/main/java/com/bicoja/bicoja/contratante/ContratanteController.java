package com.bicoja.bicoja.contratante;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contratante")
@CrossOrigin(origins = "*")
public class ContratanteController {
    private final ContratanteService service;

    public ContratanteController(ContratanteService service) { this.service = service; }

    @GetMapping
    public List<Contratante> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Contratante buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contratante criar(@Valid @RequestBody Contratante entidade) { return service.salvar(entidade); }

    @PutMapping("/{id}")
    public Contratante atualizar(@PathVariable Long id, @Valid @RequestBody Contratante entidade) {
        entidade.setIdContratante(id);
        return service.atualizar(id, entidade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) { service.excluir(id); }
}
