package com.bicoja.bicoja.contratacao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bicoja.bicoja.contratacao.dto.ContratacaoResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/contratacao")
@RequiredArgsConstructor
public class ContratacaoController {

    private final ContratacaoService contratacaoService;

    // Lista todas as contratações do profissional
    @GetMapping("/profissional/{idUsuario}")
    public ResponseEntity<List<ContratacaoResponseDTO>> listarPorProfissional(
            @PathVariable Integer idUsuario) {

        return ResponseEntity.ok(
                contratacaoService.listarPorProfissional(idUsuario)
        );
    }

    // Consulta uma contratação específica
    @GetMapping("/{id}")
    public ResponseEntity<ContratacaoResponseDTO> buscarPorId(
            @PathVariable Integer id,
            @RequestParam Integer idUsuario) {

        return ResponseEntity.ok(
                contratacaoService.buscarPorId(id, idUsuario)
        );
    }

    // Aceita ou recusa uma contratação
    @PatchMapping("/{id}/status")
    public ResponseEntity<ContratacaoResponseDTO> atualizarStatus(
            @PathVariable Integer id,
            @RequestParam Integer idUsuario,
            @RequestParam StatusContratacao status) {

        return ResponseEntity.ok(
                contratacaoService.atualizarStatus(id, idUsuario, status)
        );
    }

    // Lista contratações do profissional filtradas por status
    @GetMapping("/profissional/{idUsuario}/status")
    public ResponseEntity<List<ContratacaoResponseDTO>> listarPorProfissionalEStatus(
            @PathVariable Integer idUsuario,
            @RequestParam StatusContratacao status) {

        return ResponseEntity.ok(
                contratacaoService.listarPorProfissionalEStatus(idUsuario, status)
        );
    }
}