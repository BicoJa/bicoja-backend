package com.bicoja.bicoja.usuario;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity> login(@Valid @RequestBody LoginDTO dto) {
        service.solicitarLogin(dto);
        return ResponseEntity.ok(Map.of("mensagem", "Código de verificação enviado via SMS."));
    }

    @PostMapping("/cadastro/profissional")
    public ResponseEntity> cadastrarProfissional(@Valid @RequestBody UsuarioDTO dto) {
        UsuarioEntity usuario = service.cadastrarProfissional(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "mensagem", "Profissional registado com sucesso. Insira o código de verificação recebido.",
                "usuario", usuario
        ));
    }

    @PostMapping("/cadastro/contratante")
    public ResponseEntity> cadastrarContratante(@Valid @RequestBody UsuarioDTO dto) {
        UsuarioEntity usuario = service.cadastrarContratante(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "mensagem", "Contratante registado com sucesso. Insira o código de verificação recebido.",
                "usuario", usuario
        ));
    }

    @PostMapping("/confirmar-token")
    public ResponseEntity> confirmarToken(@Valid @RequestBody ConfirmarTokenDTO dto) {
        boolean verificado = service.validarTokenOtp(dto);

        if (verificado) {
            return ResponseEntity.ok(Map.of("mensagem", "Telefone verificado com sucesso. Acesso liberado!"));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("erro", "Código de verificação inválido ou expirado."));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
}