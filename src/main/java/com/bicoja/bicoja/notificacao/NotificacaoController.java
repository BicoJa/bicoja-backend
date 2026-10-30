package com.bicoja.bicoja.notificacao;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {

    private final NotificacaoService notificacaoService;

    public NotificacaoController(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @PostMapping
    public ResponseEntity<NotificacaoEntity> enviarNotificacao(@Valid @RequestBody NotificacaoEntity notificacao) {
        NotificacaoEntity novaNotificacao = notificacaoService.enviarNotificacao(notificacao);
        return ResponseEntity.ok(novaNotificacao);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<NotificacaoEntity>> listarPorUsuario(@PathVariable Long usuarioId) {
        List<NotificacaoEntity> lista = notificacaoService.listarPorUsuario(usuarioId);
        return ResponseEntity.ok(lista);
    }

    @PatchMapping("/{id}/lida")
    public ResponseEntity<NotificacaoEntity> marcarComoLida(@PathVariable Long id) {
        NotificacaoEntity atualizada = notificacaoService.marcarComoLida(id);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarNotificacao(@PathVariable Long id) {
        notificacaoService.deletarNotificacao(id);
        return ResponseEntity.noContent().build();
    }
}