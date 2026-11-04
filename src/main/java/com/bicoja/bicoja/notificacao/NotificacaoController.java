package com.bicoja.bicoja.notificacao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bicoja.bicoja.notificacao.dto.NotificacaoResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notificacao")
@RequiredArgsConstructor
public class NotificacaoController {

    private final NotificacaoService notificacaoService;

    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<NotificacaoResponseDTO>> listar(
            @PathVariable Integer idUsuario) {

        return ResponseEntity.ok(notificacaoService.listar(idUsuario));
    }

    @GetMapping("/{idUsuario}/nao-lidas")
    public ResponseEntity<List<NotificacaoResponseDTO>> listarNaoLidas(
            @PathVariable Integer idUsuario) {

        return ResponseEntity.ok(notificacaoService.listarNaoLidas(idUsuario));
    }

    @GetMapping("/{idUsuario}/contar-nao-lidas")
    public ResponseEntity<Long> contarNaoLidas(
            @PathVariable Integer idUsuario) {

        return ResponseEntity.ok(notificacaoService.contarNaoLidas(idUsuario));
    }

    @PatchMapping("/{idNotificacao}/lida")
    public ResponseEntity<NotificacaoResponseDTO> marcarComoLida(
            @PathVariable Integer idNotificacao,
            @RequestParam Integer idUsuario) {

        return ResponseEntity.ok(
                notificacaoService.marcarComoLida(idNotificacao, idUsuario)
        );
    }
}