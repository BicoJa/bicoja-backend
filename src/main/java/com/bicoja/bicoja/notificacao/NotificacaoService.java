package com.bicoja.bicoja.notificacao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotificacaoService {

    private final NotificacaoRepository repository;

    public NotificacaoService(NotificacaoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public NotificacaoEntity criarNotificacao(NotificacaoDTO dto) {
        NotificacaoEntity notificacao = new NotificacaoEntity(
                dto.getUsuarioId(),
                dto.getTitulo(),
                dto.getMensagem()
        );
        return repository.save(notificacao);
    }

    @Transactional(readOnly = true)
    public List<NotificacaoEntity> listarPorUsuario(Long usuarioId) {
        return repository.findByUsuarioIdOrderByDataCriacaoDesc(usuarioId);
    }

    @Transactional(readOnly = true)
    public List<NotificacaoEntity> listarNaoLidasPorUsuario(Long usuarioId) {
        return repository.findByUsuarioIdAndLidaFalseOrderByDataCriacaoDesc(usuarioId);
    }

    @Transactional(readOnly = true)
    public long contarNaoLidas(Long usuarioId) {
        return repository.countByUsuarioIdAndLidaFalse(usuarioId);
    }

    @Transactional
    public NotificacaoEntity marcarComoLida(Long id) {
        NotificacaoEntity notificacao = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Notificação não encontrada."));

        notificacao.setLida(true);
        return repository.save(notificacao);
    }

    @Transactional
    public void marcarTodasComoLidas(Long usuarioId) {
        List<NotificacaoEntity> naoLidas = repository.findByUsuarioIdAndLidaFalseOrderByDataCriacaoDesc(usuarioId);
        naoLidas.forEach(notificacao -> notificacao.setLida(true));
        repository.saveAll(naoLidas);
    }

    @Transactional
    public void deletarNotificacao(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Notificação não encontrada para remoção.");
        }
        repository.deleteById(id);
    }
}