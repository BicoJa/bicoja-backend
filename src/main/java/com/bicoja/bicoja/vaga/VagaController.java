package com.bicoja.bicoja.vaga;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vagas")
public class VagaController {

    private final VagaService service;

    public VagaController(VagaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity> publicarVaga(@Valid @RequestBody VagaDTO dto) {
        VagaEntity vaga = service.publicarVaga(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "mensagem", "Vaga publicada com sucesso!",
                "vaga", vaga
        ));
    }

    @GetMapping
    public ResponseEntity<List<VagaEntity>> listarVagasAbertas() {
        return ResponseEntity.ok(service.listarVagasAbertas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaEntity> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/contratante/{contratanteId}")
    public ResponseEntity<List<VagaEntity>> listarPorContratante(@PathVariable Long contratanteId) {
        return ResponseEntity.ok(service.listarPorContratante(contratanteId));
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<VagaEntity>> buscarPorCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(service.buscarPorCategoria(categoria));
    }

    @GetMapping("/localizacao")
    public ResponseEntity<List<VagaEntity>> buscarPorLocalizacao(
            @RequestParam String cidade,
            @RequestParam String estado) {
        return ResponseEntity.ok(service.buscarPorLocalizacao(cidade, estado));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity> atualizarStatus(
            @PathVariable Long id,
            @RequestParam VagaEntity.StatusVaga status) {
        VagaEntity vagaAtualizada = service.atualizarStatus(id, status);
        return ResponseEntity.ok(Map.of(
                "mensagem", "Status da vaga atualizado com sucesso!",
                "vaga", vagaAtualizada
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity> cancelarVaga(@PathVariable Long id) {
        service.cancelarVaga(id);
        return ResponseEntity.ok(Map.of("mensagem", "Vaga cancelada com sucesso!"));
    }
}