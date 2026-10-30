package com.bicoja.bicoja.usuario;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Armazena temporariamente os códigos OTP gerados (Telefone -> Token)
    private final Map<String, String> tokenCache = new ConcurrentHashMap<>();

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void realizarLogin(LoginDTO dto) {
        if (!usuarioRepository.existsByTelefone(dto.getTelefone())) {
            throw new RuntimeException("Usuário não encontrado com este telefone.");
        }
        gerarEEnviarOtp(dto.getTelefone());
    }

    public void cadastrarProfissional(CadastroDTO dto) {
        validarTelefoneDuplicado(dto.getTelefone());
        UsuarioEntity usuario = new UsuarioEntity(dto.getNomeCompleto(), dto.getTelefone(), "PROFISSIONAL", dto.getServicos());
        usuarioRepository.save(usuario);
        gerarEEnviarOtp(dto.getTelefone());
    }

    public void cadastrarContratante(CadastroDTO dto) {
        validarTelefoneDuplicado(dto.getTelefone());
        UsuarioEntity usuario = new UsuarioEntity(dto.getNomeCompleto(), dto.getTelefone(), "CONTRATANTE", dto.getServicos());
        usuarioRepository.save(usuario);
        gerarEEnviarOtp(dto.getTelefone());
    }

    public boolean confirmarToken(ValidarTokenDTO dto) {
        String tokenSalvo = tokenCache.get(dto.getTelefone());

        if (tokenSalvo != null && tokenSalvo.equals(dto.getToken())) {
            tokenCache.remove(dto.getTelefone()); // Remove o token após o uso

            usuarioRepository.findByTelefone(dto.getTelefone()).ifPresent(usuario -> {
                usuario.setTelefoneVerificado(true);
                usuarioRepository.save(usuario);
            });
            return true;
        }
        return false;
    }

    private void gerarEEnviarOtp(String telefone) {
        String token = String.format("%04d", new Random().nextInt(10000));
        tokenCache.put(telefone, token);

        // Simulação de disparo de SMS/WhatsApp (Substituir futuramente por API real tipo Twilio/Z-API)
        System.out.println("========================================");
        System.out.println("[TOTEM SMS] Token de 4 dígitos para " + telefone + ": " + token);
        System.out.println("========================================");
    }

    private void validarTelefoneDuplicado(String telefone) {
        if (usuarioRepository.existsByTelefone(telefone)) {
            throw new RuntimeException("Este número de telefone já está cadastrado.");
        }
    }
}