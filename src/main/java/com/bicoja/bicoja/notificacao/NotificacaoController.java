package com.bicoja.bicoja.notificacao;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {

    private final NotificacaoService service;

    public NotificacaoController(NotificacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity> criarNotificacao(@Valid @RequestBody NotificacaoDTO dto) {
        NotificacaoEntity notificacao = service.criarNotificacao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "mensagem", "Notificação enviada com sucesso!",
                "notificacao", notificacao
        ));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<NotificacaoEntity>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(service.listarPorUsuario(usuarioId));
    }

    @GetMapping("/usuario/{usuarioId}/nao-lidas")
    public ResponseEntity<List<NotificacaoEntity>> listarNaoLidasPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(service.listarNaoLidasPorUsuario(usuarioId));
    }

    @GetMapping("/usuario/{usuarioId}/contar-nao-lidas")
    public ResponseEntity> contarNaoLidas(@PathVariable Long usuarioId) {
        long quantidade = service.contarNaoLidas(usuarioId);
        return ResponseEntity.ok(Map.of("naoLidas", quantidade));
    }

    @PatchMapping("/{id}/ler")
    public ResponseEntity> marcarComoLida(@PathVariable Long id) {
        NotificacaoEntity notificacao = service.marcarComoLida(id);
        return ResponseEntity.ok(Map.of(
                "mensagem", "Notificação marcada como lida!",
                "notificacao", notificacao
        ));
    }

    @PatchMapping("/usuario/{usuarioId}/ler-todas")
    public ResponseEntity> marcarTodasComoLidas(@PathVariable Long usuarioId) {
        service.marcarTodasComoLidas(usuarioId);
        return ResponseEntity.ok(Map.of("mensagem", "Todas as notificações foram marcadas como lidas!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity> deletarNotificacao(@PathVariable Long id) {
        service.deletarNotificacao(id);
        return ResponseEntity.ok(Map.of("mensagem", "Notificação removida com sucesso!"));
    }
}