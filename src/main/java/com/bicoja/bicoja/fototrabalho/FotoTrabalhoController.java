package com.bicoja.bicoja.fototrabalho;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fotos-trabalho")
public class FotoTrabalhoController {

    private final FotoTrabalhoService service;

    public FotoTrabalhoController(FotoTrabalhoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity> adicionarFoto(@Valid @RequestBody FotoTrabalhoDTO dto) {
        FotoTrabalhoEntity foto = service.adicionarFoto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "mensagem", "Foto do trabalho adicionada com sucesso!",
                "foto", foto
        ));
    }

    @GetMapping("/profissional/{profissionalId}")
    public ResponseEntity<List<FotoTrabalhoEntity>> listarPorProfissional(@PathVariable Long profissionalId) {
        return ResponseEntity.ok(service.listarPorProfissional(profissionalId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FotoTrabalhoEntity> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity> removerFoto(@PathVariable Long id) {
        service.removerFoto(id);
        return ResponseEntity.ok(Map.of("mensagem", "Foto removida com sucesso!"));
    }
}