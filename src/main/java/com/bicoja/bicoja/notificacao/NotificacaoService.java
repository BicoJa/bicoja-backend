package com.bicoja.bicoja.notificacao;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bicoja.bicoja.notificacao.dto.NotificacaoResponseDTO;
import com.bicoja.bicoja.usuario.UsuarioEntity;
import com.bicoja.bicoja.usuario.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;
    private final UsuarioRepository usuarioRepository;

    public NotificacaoEntity criar(Integer idUsuario, String mensagem) {

        UsuarioEntity usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        NotificacaoEntity notificacao = new NotificacaoEntity();
        notificacao.setUsuario(usuario);
        notificacao.setMensagem(mensagem);
        notificacao.setLida(false);

        return notificacaoRepository.save(notificacao);
    }

    public List<NotificacaoResponseDTO> listar(Integer idUsuario) {

        return notificacaoRepository.buscarPorUsuario(idUsuario)
                .stream()
                .map(NotificacaoResponseDTO::fromEntity)
                .toList();
    }

    public List<NotificacaoResponseDTO> listarNaoLidas(Integer idUsuario) {

        return notificacaoRepository.buscarNaoLidas(idUsuario)
                .stream()
                .map(NotificacaoResponseDTO::fromEntity)
                .toList();
    }

    public long contarNaoLidas(Integer idUsuario) {

        return notificacaoRepository.contarNaoLidas(idUsuario);
    }

    @Transactional
    public NotificacaoResponseDTO marcarComoLida(Integer idNotificacao, Integer idUsuario) {

        NotificacaoEntity notificacao = notificacaoRepository.findById(idNotificacao)
                .orElseThrow(() -> new RuntimeException("Notificação não encontrada."));

        if (!notificacao.getUsuario().getId_usuario().equals(idUsuario)) {
            throw new RuntimeException("Você não tem permissão para alterar esta notificação.");
        }

        notificacao.setLida(true);

        NotificacaoEntity salva = notificacaoRepository.save(notificacao);

        return NotificacaoResponseDTO.fromEntity(salva);
    }
}