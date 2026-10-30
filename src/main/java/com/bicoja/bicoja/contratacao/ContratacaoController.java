package com.bicoja.bicoja.contratacao;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratacoes")
public class ContratacaoController {

    private final ContratacaoService contratacaoService;

    public ContratacaoController(ContratacaoService contratacaoService) {
        this.contratacaoService = contratacaoService;
    }

    @PostMapping
    public ResponseEntity<ContratacaoEntity> criarContratacao(@Valid @RequestBody ContratacaoEntity contratacao) {
        ContratacaoEntity novaContratacao = contratacaoService.criarContratacao(contratacao);
        return ResponseEntity.ok(novaContratacao);
    }

    @GetMapping("/profissional/{profissionalId}")
    public ResponseEntity<List<ContratacaoEntity>> listarPorProfissional(@PathVariable Long profissionalId) {
        List<ContratacaoEntity> lista = contratacaoService.listarPorProfissional(profissionalId);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/contratante/{contratanteId}")
    public ResponseEntity<List<ContratacaoEntity>> listarPorContratante(@PathVariable Long contratanteId) {
        List<ContratacaoEntity> lista = contratacaoService.listarPorContratante(contratanteId);
        return ResponseEntity.ok(lista);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ContratacaoEntity> atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        ContratacaoEntity atualizada = contratacaoService.atualizarStatus(id, status);
        return ResponseEntity.ok(atualizada);
    }
}