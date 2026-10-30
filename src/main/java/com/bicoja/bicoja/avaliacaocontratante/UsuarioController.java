package com.bicoja.bicoja.usuario;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Tela 1: Login
    @PostMapping("/login")
    public ResponseEntity> login(@Valid @RequestBody LoginDTO dto) {
        usuarioService.realizarLogin(dto);
        return ResponseEntity.ok(Map.of("mensagem", "Código de confirmação enviado via SMS."));
    }

    // Tela 2: Cadastro Profissional
    @PostMapping("/cadastro/profissional")
    public ResponseEntity> cadastrarProfissional(@Valid @RequestBody CadastroDTO dto) {
        usuarioService.cadastrarProfissional(dto);
        return ResponseEntity.ok(Map.of("mensagem", "Cadastro profissional realizado com sucesso. Verifique o totem SMS."));
    }

    // Tela 3: Cadastro Contratante
    @PostMapping("/cadastro/contratante")
    public ResponseEntity> cadastrarContratante(@Valid @RequestBody CadastroDTO dto) {
        usuarioService.cadastrarContratante(dto);
        return ResponseEntity.ok(Map.of("mensagem", "Cadastro de contratante realizado com sucesso. Verifique o totem SMS."));
    }

    // Tela 4: Totens de Confirmação Telefônica (OTP de 4 dígitos)
    @PostMapping("/verificar-token")
    public ResponseEntity> verificarToken(@Valid @RequestBody ValidarTokenDTO dto) {
        boolean sucesso = usuarioService.confirmarToken(dto);
        if (sucesso) {
            return ResponseEntity.ok(Map.of("mensagem", "Telefone verificado e conta ativada com sucesso!"));
        } else {
            return ResponseEntity.badRequest().body(Map.of("erro", "Código OTP inválido ou expirado."));
        }
    }
}