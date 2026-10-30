package com.bicoja.bicoja.profissional;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profissionais")
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService) {
        this.profissionalService = profissionalService;
    }

    @PostMapping
    public ResponseEntity<ProfissionalEntity> criar(@Valid @RequestBody ProfissionalEntity profissional) {
        ProfissionalEntity novoProfissional = profissionalService.salvar(profissional);
        return ResponseEntity.ok(novoProfissional);
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalEntity>> listarTodos() {
        List<ProfissionalEntity> profissionais = profissionalService.listarTodos();
        return ResponseEntity.ok(profissionais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalEntity> buscarPorId(@PathVariable Long id) {
        ProfissionalEntity profissional = profissionalService.buscarPorId(id);
        return ResponseEntity.ok(profissional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        profissionalService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}