package com.bicoja.bicoja.vaga;

import com.bicoja.bicoja.vaga.dto.AtualizarStatusVagaDTO;
import com.bicoja.bicoja.vaga.dto.VagaRequestDTO;
import com.bicoja.bicoja.vaga.dto.VagaResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaga")
public class VagaController {

    private final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @PostMapping
    public ResponseEntity<Void> criarVaga(@RequestBody VagaRequestDTO dto) {

        vagaService.criarVaga(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/profissional/{idUsuario}")
    public ResponseEntity<List<VagaResponseDTO>> buscarVagasPorProfissional(
            @PathVariable Integer idUsuario) {

        List<VagaResponseDTO> vagas =
                vagaService.buscarVagasPorProfissional(idUsuario);

        return ResponseEntity.ok(vagas);
    }

    @GetMapping("/contratante/{idUsuario}")
    public ResponseEntity<List<VagaResponseDTO>> buscarVagasPorContratante(
            @PathVariable Integer idUsuario,
            @RequestParam StatusVaga status) {

        List<VagaResponseDTO> vagas =
                vagaService.buscarVagasPorContratante(idUsuario, status);

        return ResponseEntity.ok(vagas);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> atualizarStatus(
            @PathVariable Integer id,
            @RequestBody AtualizarStatusVagaDTO dto) {

        vagaService.atualizarStatus(id, dto.status());

        return ResponseEntity.noContent().build();

    }

}