package com.bicoja.bicoja.avaliacaoprofissional;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes/profissional")
public class AvaliacaoProfissionalController {

    private final AvaliacaoProfissionalService service;

    public AvaliacaoProfissionalController(AvaliacaoProfissionalService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AvaliacaoProfissionalEntity> criarAvaliacao(@Valid @RequestBody AvaliacaoProfissionalEntity avaliacao) {
        AvaliacaoProfissionalEntity novaAvaliacao = service.criarAvaliacao(avaliacao);
        return ResponseEntity.ok(novaAvaliacao);
    }

    @GetMapping("/profissional/{profissionalId}")
    public ResponseEntity<List<AvaliacaoProfissionalEntity>> listarPorProfissional(@PathVariable Long profissionalId) {
        List<AvaliacaoProfissionalEntity> avaliacoes = service.listarPorProfissional(profissionalId);
        return ResponseEntity.ok(avaliacoes);
    }
}