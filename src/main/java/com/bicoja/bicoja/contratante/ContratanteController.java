package com.bicoja.bicoja.contratante;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/contratantes")
public class ContratanteController {

    private final ContratanteService service;

    public ContratanteController(ContratanteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity> criarPerfil(@Valid @RequestBody ContratanteDTO dto) {
        ContratanteEntity perfil = service.criarPerfil(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "mensagem", "Perfil de contratante criado com sucesso!",
                "contratante", perfil
        ));
    }

    @GetMapping
    public ResponseEntity<List<ContratanteEntity>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratanteEntity> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<ContratanteEntity> buscarPorUsuarioId(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(service.buscarPorUsuarioId(usuarioId));
    }

    @PutMapping("/{id}")
    public ResponseEntity> atualizarPerfil(@PathVariable Long id, @RequestBody ContratanteDTO dto) {
        ContratanteEntity perfilAtualizado = service.atualizarPerfil(id, dto);
        return ResponseEntity.ok(Map.of(
                "mensagem", "Perfil de contratante atualizado com sucesso!",
                "contratante", perfilAtualizado
        ));
    }
}