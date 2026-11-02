package com.bicoja.bicoja.profissional;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profissional")
@CrossOrigin(origins = "*")
public class ProfissionalController {
    private final ProfissionalService service;

    public ProfissionalController(ProfissionalService service) { this.service = service; }

    @GetMapping
    public List<Profissional> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Profissional buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profissional criar(@Valid @RequestBody Profissional entidade) { return service.salvar(entidade); }

    @PutMapping("/{id}")
    public Profissional atualizar(@PathVariable Long id, @Valid @RequestBody Profissional entidade) {
        entidade.setIdProfissional(id);
        return service.atualizar(id, entidade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) { service.excluir(id); }
}
