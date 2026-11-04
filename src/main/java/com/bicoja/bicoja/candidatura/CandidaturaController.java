package com.bicoja.bicoja.candidatura;

import java.util.List;

import com.bicoja.bicoja.candidatura.dto.AtualizarStatusCandidaturaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bicoja.bicoja.candidatura.dto.CandidaturaResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/candidatura")
@RequiredArgsConstructor
public class CandidaturaController {

    private final CandidaturaService candidaturaService;

    // Criar candidatura
    @PostMapping
    public ResponseEntity<CandidaturaResponseDTO> criar(
            @RequestParam Integer idVaga,
            @RequestParam Integer idUsuario) {

        CandidaturaResponseDTO resposta =
                candidaturaService.criar(idVaga, idUsuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    // Listar candidaturas de um profissional
    @GetMapping("/profissional/{idUsuario}")
    public ResponseEntity<List<CandidaturaResponseDTO>> listarPorProfissional(
            @PathVariable Integer idUsuario) {

        return ResponseEntity.ok(
                candidaturaService.listarPorProfissional(idUsuario)
        );
    }

    // Listar profissionais que se candidataram a uma vaga
    @GetMapping("/vaga/{idVaga}")
    public ResponseEntity<List<CandidaturaResponseDTO>> listarPorVaga(
            @PathVariable Integer idVaga) {

        return ResponseEntity.ok(
                candidaturaService.listarPorVaga(idVaga)
        );
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<CandidaturaResponseDTO> atualizarStatus(
            @PathVariable Integer id,
            @RequestBody AtualizarStatusCandidaturaDTO dto) {

        CandidaturaResponseDTO resposta = candidaturaService.atualizarStatus(
                id,
                dto.idUsuario(),
                dto.status()
        );

        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/profissional/{idUsuario}/status")
    public ResponseEntity<List<CandidaturaResponseDTO>> listarPorProfissionalEStatus(
            @PathVariable Integer idUsuario,
            @RequestParam StatusCandidatura status) {

        return ResponseEntity.ok(
                candidaturaService.listarPorProfissionalEStatus(idUsuario, status)
        );
    }

    @GetMapping("/vaga/{idVaga}/status")
    public ResponseEntity<List<CandidaturaResponseDTO>> listarPorVagaEStatus(
            @PathVariable Integer idVaga,
            @RequestParam StatusCandidatura status) {

        return ResponseEntity.ok(
                candidaturaService.listarPorVagaEStatus(idVaga, status)
        );
    }

    // Cancelar candidatura pelo profissional
    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<CandidaturaResponseDTO> cancelar(
            @PathVariable Integer id,
            @RequestParam Integer idUsuario) {

        CandidaturaResponseDTO resposta = candidaturaService.cancelar(
                id,
                idUsuario
        );

        return ResponseEntity.ok(resposta);
    }
}