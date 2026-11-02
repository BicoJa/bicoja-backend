package com.bicoja.bicoja.profissionalhabilidade;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profissionalhabilidade")
@CrossOrigin(origins = "*")
public class ProfissionalHabilidadeController {
    private final ProfissionalHabilidadeService service;

    public ProfissionalHabilidadeController(ProfissionalHabilidadeService service) { this.service = service; }

    @GetMapping
    public List<ProfissionalHabilidade> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public ProfissionalHabilidade buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfissionalHabilidade criar(@Valid @RequestBody ProfissionalHabilidade entidade) { return service.salvar(entidade); }

    @PutMapping("/{id}")
    public ProfissionalHabilidade atualizar(@PathVariable Long id, @Valid @RequestBody ProfissionalHabilidade entidade) {
        entidade.setIdProfissionalHabilidade(id);
        return service.atualizar(id, entidade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) { service.excluir(id); }
}
