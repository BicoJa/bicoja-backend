package com.bicoja.bicoja.candidatura;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidaturas")
public class CandidaturaController {

    private final CandidaturaService candidaturaService;

    public CandidaturaController(CandidaturaService candidaturaService) {
        this.candidaturaService = candidaturaService;
    }

    @PostMapping
    public ResponseEntity<CandidaturaEntity> realizarCandidatura(@Valid @RequestBody CandidaturaEntity candidatura) {
        CandidaturaEntity novaCandidatura = candidaturaService.realizarCandidatura(candidatura);
        return ResponseEntity.ok(novaCandidatura);
    }

    @GetMapping("/vaga/{vagaId}")
    public ResponseEntity<List<CandidaturaEntity>> listarPorVaga(@PathVariable Long vagaId) {
        List<CandidaturaEntity> candidaturas = candidaturaService.listarPorVaga(vagaId);
        return ResponseEntity.ok(candidaturas);
    }

    @GetMapping("/profissional/{profissionalId}")
    public ResponseEntity<List<CandidaturaEntity>> listarPorProfissional(@PathVariable Long profissionalId) {
        List<CandidaturaEntity> candidaturas = candidaturaService.listarPorProfissional(profissionalId);
        return ResponseEntity.ok(candidaturas);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<CandidaturaEntity> atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        CandidaturaEntity atualizada = candidaturaService.atualizarStatus(id, status);
        return ResponseEntity.ok(atualizada);
    }
}