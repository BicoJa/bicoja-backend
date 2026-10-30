package com.bicoja.bicoja.profissional;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/profissionais")
public class ProfissionalController {

    private final ProfissionalService service;

    public ProfissionalController(ProfissionalService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity> criarPerfil(@Valid @RequestBody ProfissionalDTO dto) {
        ProfissionalEntity perfil = service.criarPerfil(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "mensagem", "Perfil de profissional criado com sucesso!",
                "profissional", perfil
        ));
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalEntity>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalEntity> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<ProfissionalEntity> buscarPorUsuarioId(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(service.buscarPorUsuarioId(usuarioId));
    }

    @GetMapping("/localizacao")
    public ResponseEntity<List<ProfissionalEntity>> buscarPorLocalizacao(
            @RequestParam String cidade,
            @RequestParam String estado) {
        return ResponseEntity.ok(service.buscarPorLocalizacao(cidade, estado));
    }

    @PutMapping("/{id}")
    public ResponseEntity> atualizarPerfil(@PathVariable Long id, @RequestBody ProfissionalDTO dto) {
        ProfissionalEntity perfilAtualizado = service.atualizarPerfil(id, dto);
        return ResponseEntity.ok(Map.of(
                "mensagem", "Perfil de profissional atualizado com sucesso!",
                "profissional", perfilAtualizado
        ));
    }
}