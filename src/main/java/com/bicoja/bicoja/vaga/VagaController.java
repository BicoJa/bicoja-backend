package com.bicoja.bicoja.vaga;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vagas")
public class VagaController {

    private final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @PostMapping
    public ResponseEntity<VagaEntity> publicarVaga(@Valid @RequestBody VagaEntity vaga) {
        VagaEntity novaVaga = vagaService.publicarVaga(vaga);
        return ResponseEntity.ok(novaVaga);
    }

    @GetMapping
    public ResponseEntity<List<VagaEntity>> listarVagasAbertas() {
        List<VagaEntity> vagas = vagaService.listarVagasAbertas();
        return ResponseEntity.ok(vagas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VagaEntity> buscarPorId(@PathVariable Long id) {
        VagaEntity vaga = vagaService.buscarPorId(id);
        return ResponseEntity.ok(vaga);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVaga(@PathVariable Long id) {
        vagaService.deletarVaga(id);
        return ResponseEntity.noContent().build();
    }
}