package com.bicoja.bicoja.avaliacaoprofissional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bicoja.bicoja.avaliacaoprofissional.dto.AvaliacaoProfissionalRequestDTO;
import com.bicoja.bicoja.avaliacaoprofissional.dto.AvaliacaoProfissionalResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/avaliacao-profissional")
@RequiredArgsConstructor
public class AvaliacaoProfissionalController {

    private final AvaliacaoProfissionalService avaliacaoService;

    @PostMapping("/{idContratacao}")
    public ResponseEntity<AvaliacaoProfissionalResponseDTO> avaliar(
            @PathVariable Integer idContratacao,
            @RequestParam Integer idUsuario,
            @RequestBody AvaliacaoProfissionalRequestDTO dados) {

        return ResponseEntity.ok(
                avaliacaoService.avaliar(idContratacao, idUsuario, dados)
        );
    }
}