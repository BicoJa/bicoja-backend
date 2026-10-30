package com.bicoja.bicoja.usuario;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    // Armazenamento em memória para tokens OTP temporários (Telefone -> Token)
    private final Map<String, String> tokenStorage = new ConcurrentHashMap<>();

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public void solicitarLogin(LoginDTO dto) {
        String telefoneLimpo = sanitizarTelefone(dto.getTelefone());

        UsuarioEntity usuario = repository.findByTelefone(telefoneLimpo)
                .orElseThrow(() -> new IllegalArgumentException("Utilizador não encontrado com o telefone informado."));

        gerarEEnviarOtp(usuario.getTelefone());
    }

    @Transactional
    public UsuarioEntity cadastrarProfissional(UsuarioDTO dto) {
        return cadastrarUsuario(dto, UsuarioEntity.TipoUsuario.PROFISSIONAL);
    }

    @Transactional
    public UsuarioEntity cadastrarContratante(UsuarioDTO dto) {
        return cadastrarUsuario(dto, UsuarioEntity.TipoUsuario.CONTRATANTE);
    }

    @Transactional
    public boolean validarTokenOtp(ConfirmarTokenDTO dto) {
        String telefoneLimpo = sanitizarTelefone(dto.getTelefone());
        String tokenSalvo = tokenStorage.get(telefoneLimpo);

        if (tokenSalvo != null && tokenSalvo.equals(dto.getToken())) {
            tokenStorage.remove(telefoneLimpo);

            repository.findByTelefone(telefoneLimpo).ifPresent(usuario -> {
                usuario.setTelefoneVerificado(true);
                repository.save(usuario);
            });
            return true;
        }

        return false;
    }

    @Transactional(readOnly = true)
    public UsuarioEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilizador não encontrado."));
    }

    @Transactional(readOnly = true)
    public List<UsuarioEntity> listarTodos() {
        return repository.findAll();
    }

    private UsuarioEntity cadastrarUsuario(UsuarioDTO dto, UsuarioEntity.TipoUsuario tipoUsuario) {
        String telefoneLimpo = sanitizarTelefone(dto.getTelefone());

        if (repository.existsByTelefone(telefoneLimpo)) {
            throw new IllegalStateException("Número de telefone já se encontra registado.");
        }

        UsuarioEntity usuario = new UsuarioEntity(
                dto.getNomeCompleto(),
                telefoneLimpo,
                tipoUsuario,
                dto.getServicos()
        );

        UsuarioEntity usuarioSalvo = repository.save(usuario);
        gerarEEnviarOtp(telefoneLimpo);
        return usuarioSalvo;
    }

    private void gerarEEnviarOtp(String telefone) {
        SecureRandom random = new SecureRandom();
        String token = String.format("%04d", random.nextInt(10000));
        tokenStorage.put(telefone, token);

        System.out.println("==========================================");
        System.out.println("[TOTEM SMS] Código enviado para " + telefone + ": " + token);
        System.out.println("==========================================");
    }

    private String sanitizarTelefone(String telefone) {
        return telefone.replaceAll("[^0-9]", "");
    }
}