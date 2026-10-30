package com.bicoja.bicoja.habilidade;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadeController {

    private final HabilidadeService habilidadeService;

    public HabilidadeController(HabilidadeService habilidadeService) {
        this.habilidadeService = habilidadeService;
    }

    @PostMapping
    public ResponseEntity<HabilidadeEntity> criarHabilidade(@Valid @RequestBody HabilidadeEntity habilidade) {
        HabilidadeEntity novaHabilidade = habilidadeService.criarHabilidade(habilidade);
        return ResponseEntity.ok(novaHabilidade);
    }

    @GetMapping
    public ResponseEntity<List<HabilidadeEntity>> listarTodas() {
        List<HabilidadeEntity> habilidades = habilidadeService.listarTodas();
        return ResponseEntity.ok(habilidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabilidadeEntity> buscarPorId(@PathVariable Long id) {
        HabilidadeEntity habilidade = habilidadeService.buscarPorId(id);
        return ResponseEntity.ok(habilidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarHabilidade(@PathVariable Long id) {
        habilidadeService.deletarHabilidade(id);
        return ResponseEntity.noContent().build();
    }
}