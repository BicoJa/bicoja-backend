package com.bicoja.bicoja.fototrabalho;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fotos-trabalho")
public class FotoTrabalhoController {

    private final FotoTrabalhoService fotoTrabalhoService;

    public FotoTrabalhoController(FotoTrabalhoService fotoTrabalhoService) {
        this.fotoTrabalhoService = fotoTrabalhoService;
    }

    @PostMapping
    public ResponseEntity<FotoTrabalhoEntity> adicionarFoto(@Valid @RequestBody FotoTrabalhoEntity foto) {
        FotoTrabalhoEntity novaFoto = fotoTrabalhoService.salvar(foto);
        return ResponseEntity.ok(novaFoto);
    }

    @GetMapping("/profissional/{profissionalId}")
    public ResponseEntity<List<FotoTrabalhoEntity>> listarPorProfissional(@PathVariable Long profissionalId) {
        List<FotoTrabalhoEntity> fotos = fotoTrabalhoService.listarPorProfissional(profissionalId);
        return ResponseEntity.ok(fotos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFoto(@PathVariable Long id) {
        fotoTrabalhoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}