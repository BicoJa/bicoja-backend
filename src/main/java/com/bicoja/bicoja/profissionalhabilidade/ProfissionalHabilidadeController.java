package com.bicoja.bicoja.profissionalhabilidade;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/profissional-habilidades")
public class ProfissionalHabilidadeController {

    private final ProfissionalHabilidadeService service;

    public ProfissionalHabilidadeController(ProfissionalHabilidadeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity> vincular(@Valid @RequestBody ProfissionalHabilidadeDTO dto) {
        ProfissionalHabilidadeEntity vinculo = service.vincularHabilidade(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "mensagem", "Habilidade vinculada ao profissional com sucesso!",
                "vinculo", vinculo
        ));
    }

    @GetMapping("/profissional/{profissionalId}")
    public ResponseEntity<List<ProfissionalHabilidadeEntity>> listarPorProfissional(@PathVariable Long profissionalId) {
        return ResponseEntity.ok(service.listarPorProfissional(profissionalId));
    }

    @GetMapping("/habilidade/{habilidadeId}")
    public ResponseEntity<List<ProfissionalHabilidadeEntity>> listarPorHabilidade(@PathVariable Long habilidadeId) {
        return ResponseEntity.ok(service.listarPorHabilidade(habilidadeId));
    }

    @DeleteMapping
    public ResponseEntity> desvincular(
            @RequestParam Long profissionalId,
            @RequestParam Long habilidadeId) {
        service.desvincularHabilidade(profissionalId, habilidadeId);
        return ResponseEntity.ok(Map.of("mensagem", "Habilidade desvinculada do profissional com sucesso!"));
    }
}