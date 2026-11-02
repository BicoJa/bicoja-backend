package com.bicoja.bicoja.fototrabalho;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fototrabalho")
@CrossOrigin(origins = "*")
public class FotoTrabalhoController {
    private final FotoTrabalhoService service;

    public FotoTrabalhoController(FotoTrabalhoService service) { this.service = service; }

    @GetMapping
    public List<FotoTrabalho> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public FotoTrabalho buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FotoTrabalho criar(@Valid @RequestBody FotoTrabalho entidade) { return service.salvar(entidade); }

    @PutMapping("/{id}")
    public FotoTrabalho atualizar(@PathVariable Long id, @Valid @RequestBody FotoTrabalho entidade) {
        entidade.setId(id);
        return service.atualizar(id, entidade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) { service.excluir(id); }
}
