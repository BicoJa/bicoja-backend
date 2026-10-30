package com.bicoja.bicoja.usuario;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void realizarLogin(LoginDTO dto) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findByTelefone(dto.getTelefone());
        if (usuario.isPresent()) {
            // Lógica para enviar SMS OTP simulada
            UsuarioEntity u = usuario.get();
            u.setTokenOtp("1234"); // Exemplo de OTP fixo para teste
            usuarioRepository.save(u);
        } else {
            throw new RuntimeException("Usuário não encontrado com este telefone.");
        }
    }

    public void cadastrarProfissional(CadastroDTO dto) {
        if (usuarioRepository.existsByTelefone(dto.getTelefone())) {
            throw new RuntimeException("Telefone já cadastrado.");
        }
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNomeCompleto(dto.getNomeCompleto());
        usuario.setTelefone(dto.getTelefone());
        usuario.setTipoUsuario("PROFISSIONAL");
        usuario.setServicos(dto.getServicos());
        usuario.setTokenOtp("1234");
        usuarioRepository.save(usuario);
    }

    public void cadastrarContratante(CadastroDTO dto) {
        if (usuarioRepository.existsByTelefone(dto.getTelefone())) {
            throw new RuntimeException("Telefone já cadastrado.");
        }
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNomeCompleto(dto.getNomeCompleto());
        usuario.setTelefone(dto.getTelefone());
        usuario.setTipoUsuario("CONTRATANTE");
        usuario.setTokenOtp("1234");
        usuarioRepository.save(usuario);
    }

    public boolean confirmarToken(ValidarTokenDTO dto) {
        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findByTelefone(dto.getTelefone());
        if (usuarioOpt.isPresent()) {
            UsuarioEntity usuario = usuarioOpt.get();
            if ("1234".equals(dto.getToken())) { // Validação simples do token
                usuario.setTelefoneVerificado(true);
                usuario.setTokenOtp(null);
                usuarioRepository.save(usuario);
                return true;
            }
        }
        return false;
    }
}