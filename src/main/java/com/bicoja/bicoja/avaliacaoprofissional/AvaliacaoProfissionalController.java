package com.bicoja.bicoja.avaliacaoprofissional;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/avaliacoes/profissional")
public class AvaliacaoProfissionalController {

    private final AvaliacaoProfissionalService service;

    public AvaliacaoProfissionalController(AvaliacaoProfissionalService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity> criarAvaliacao(@Valid @RequestBody AvaliacaoProfissionalDTO dto) {
        AvaliacaoProfissionalEntity novaAvaliacao = service.salvarAvaliacao(dto);
        return ResponseEntity.ok(Map.of(
                "mensagem", "Avaliação do profissional registrada com sucesso!",
                "avaliacao", novaAvaliacao
        ));
    }

    @GetMapping("/{profissionalId}")
    public ResponseEntity<List<AvaliacaoProfissionalEntity>> listarPorProfissional(@PathVariable Long profissionalId) {
        List<AvaliacaoProfissionalEntity> avaliacoes = service.listarPorProfissional(profissionalId);
        return ResponseEntity.ok(avaliacoes);
    }
}