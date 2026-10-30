package com.bicoja.bicoja.profissionalhabilidade;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profissional-habilidades")
public class ProfissionalHabilidadeController {

    private final ProfissionalHabilidadeService service;

    public ProfissionalHabilidadeController(ProfissionalHabilidadeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProfissionalHabilidadeEntity> associar(@Valid @RequestBody ProfissionalHabilidadeEntity associacao) {
        ProfissionalHabilidadeEntity novaAssociacao = service.associar(associacao);
        return ResponseEntity.ok(novaAssociacao);
    }

    @GetMapping("/profissional/{profissionalId}")
    public ResponseEntity<List<ProfissionalHabilidadeEntity>> listarPorProfissional(@PathVariable Long profissionalId) {
        List<ProfissionalHabilidadeEntity> lista = service.listarPorProfissional(profissionalId);
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping
    public ResponseEntity<Void> desassociar(@RequestParam Long profissionalId, @RequestParam Long habilidadeId) {
        service.desassociar(profissionalId, habilidadeId);
        return ResponseEntity.noContent().build();
    }
}