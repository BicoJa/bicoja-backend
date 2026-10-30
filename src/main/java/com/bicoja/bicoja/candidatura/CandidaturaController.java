package com.bicoja.bicoja.candidatura;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/candidaturas")
public class CandidaturaController {

    private final CandidaturaService service;

    public CandidaturaController(CandidaturaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity> aplicarParaVaga(@Valid @RequestBody CandidaturaDTO dto) {
        CandidaturaEntity novaCandidatura = service.aplicarParaVaga(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "mensagem", "Candidatura enviada com sucesso!",
                "candidatura", novaCandidatura
        ));
    }

    @GetMapping("/vaga/{vagaId}")
    public ResponseEntity<List<CandidaturaEntity>> listarPorVaga(@PathVariable Long vagaId) {
        return ResponseEntity.ok(service.listarPorVaga(vagaId));
    }

    @GetMapping("/profissional/{profissionalId}")
    public ResponseEntity<List<CandidaturaEntity>> listarPorProfissional(@PathVariable Long profissionalId) {
        return ResponseEntity.ok(service.listarPorProfissional(profissionalId));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity> atualizarStatus(
            @PathVariable Long id,
            @RequestParam CandidaturaEntity.StatusCandidatura status) {

        CandidaturaEntity candidaturaAtualizada = service.atualizarStatus(id, status);
        return ResponseEntity.ok(Map.of(
                "mensagem", "Status da candidatura atualizado com sucesso!",
                "candidatura", candidaturaAtualizada
        ));
    }
}