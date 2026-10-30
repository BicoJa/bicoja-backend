package com.bicoja.bicoja.contratacao;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/contratacoes")
public class ContratacaoController {

    private final ContratacaoService service;

    public ContratacaoController(ContratacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity> criarContratacao(@Valid @RequestBody ContratacaoDTO dto) {
        ContratacaoEntity novaContratacao = service.criarContratacao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "mensagem", "Contratação realizada com sucesso!",
                "contratacao", novaContratacao
        ));
    }

    @GetMapping("/contratante/{contratanteId}")
    public ResponseEntity<List<ContratacaoEntity>> listarPorContratante(@PathVariable Long contratanteId) {
        return ResponseEntity.ok(service.listarPorContratante(contratanteId));
    }

    @GetMapping("/profissional/{profissionalId}")
    public ResponseEntity<List<ContratacaoEntity>> listarPorProfissional(@PathVariable Long profissionalId) {
        return ResponseEntity.ok(service.listarPorProfissional(profissionalId));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity> atualizarStatus(
            @PathVariable Long id,
            @RequestParam ContratacaoEntity.StatusContratacao status) {

        ContratacaoEntity contratacaoAtualizada = service.atualizarStatus(id, status);
        return ResponseEntity.ok(Map.of(
                "mensagem", "Status da contratação atualizado com sucesso!",
                "contratacao", contratacaoAtualizada
        ));
    }
}