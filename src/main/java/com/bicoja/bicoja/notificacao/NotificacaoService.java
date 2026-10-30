package com.bicoja.bicoja.notificacao;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;

    public NotificacaoService(NotificacaoRepository notificacaoRepository) {
        this.notificacaoRepository = notificacaoRepository;
    }

    public NotificacaoEntity enviarNotificacao(NotificacaoEntity notificacao) {
        notificacao.setLida(false);
        return notificacaoRepository.save(notificacao);
    }

    public List<NotificacaoEntity> listarPorUsuario(Long usuarioId) {
        return notificacaoRepository.findByUsuarioId(usuarioId);
    }

    public NotificacaoEntity marcarComoLida(Long id) {
        NotificacaoEntity notificacao = notificacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificação não encontrada com o ID: " + id));

        notificacao.setLida(true);
        return notificacaoRepository.save(notificacao);
    }

    public void deletarNotificacao(Long id) {
        NotificacaoEntity notificacao = notificacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificação não encontrada com o ID: " + id));
        notificacaoRepository.delete(notificacao);
    }
}