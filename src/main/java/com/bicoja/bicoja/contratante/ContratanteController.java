package com.bicoja.bicoja.contratante;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratantes")
public class ContratanteController {

    private final ContratanteService contratanteService;

    public ContratanteController(ContratanteService contratanteService) {
        this.contratanteService = contratanteService;
    }

    @PostMapping
    public ResponseEntity<ContratanteEntity> criar(@Valid @RequestBody ContratanteEntity contratante) {
        ContratanteEntity novoContratante = contratanteService.salvar(contratante);
        return ResponseEntity.ok(novoContratante);
    }

    @GetMapping
    public ResponseEntity<List<ContratanteEntity>> listarTodos() {
        List<ContratanteEntity> contratantes = contratanteService.listarTodos();
        return ResponseEntity.ok(contratantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratanteEntity> buscarPorId(@PathVariable Long id) {
        ContratanteEntity contratante = contratanteService.buscarPorId(id);
        return ResponseEntity.ok(contratante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        contratanteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}