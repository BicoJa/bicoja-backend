package com.bicoja.bicoja.habilidade;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadeController {

    private final HabilidadeService service;

    public HabilidadeController(HabilidadeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity> criarHabilidade(@Valid @RequestBody HabilidadeDTO dto) {
        HabilidadeEntity habilidade = service.criarHabilidade(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "mensagem", "Habilidade criada com sucesso!",
                "habilidade", habilidade
        ));
    }

    @GetMapping
    public ResponseEntity<List<HabilidadeEntity>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabilidadeEntity> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity> atualizarHabilidade(@PathVariable Long id, @Valid @RequestBody HabilidadeDTO dto) {
        HabilidadeEntity habilidadeAtualizada = service.atualizarHabilidade(id, dto);
        return ResponseEntity.ok(Map.of(
                "mensagem", "Habilidade atualizada com sucesso!",
                "habilidade", habilidadeAtualizada
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity> deletarHabilidade(@PathVariable Long id) {
        service.deletarHabilidade(id);
        return ResponseEntity.ok(Map.of("mensagem", "Habilidade removida com sucesso!"));
    }
}