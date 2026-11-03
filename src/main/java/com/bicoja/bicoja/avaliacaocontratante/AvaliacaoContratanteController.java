package com.bicoja.bicoja.avaliacaocontratante;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes/contratante")
public class AvaliacaoContratanteController {

    private final AvaliacaoContratanteService service;

    public AvaliacaoContratanteController(AvaliacaoContratanteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AvaliacaoContratanteEntity> criarAvaliacao(@Valid @RequestBody AvaliacaoContratanteEntity avaliacao) {
        AvaliacaoContratanteEntity novaAvaliacao = service.criarAvaliacao(avaliacao);
        return ResponseEntity.ok(novaAvaliacao);
    }

    @GetMapping("/contratante/{contratanteId}")
    public ResponseEntity<List<AvaliacaoContratanteEntity>> listarPorContratante(@PathVariable Long contratanteId) {
        List<AvaliacaoContratanteEntity> avaliacoes = service.listarPorContratante(contratanteId);
        return ResponseEntity.ok(avaliacoes);
    }
}