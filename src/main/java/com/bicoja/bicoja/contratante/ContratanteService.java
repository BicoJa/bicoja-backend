package com.bicoja.bicoja.contratante;

import com.bicoja.bicoja.usuario.UsuarioEntity;
import com.bicoja.bicoja.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContratanteService {

    private final ContratanteRepository repository;
    private final UsuarioRepository usuarioRepository;

    public ContratanteService(ContratanteRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public ContratanteEntity criarPerfil(ContratanteDTO dto) {
        if (repository.existsByUsuarioId(dto.getUsuarioId())) {
            throw new IllegalStateException("Já existe um perfil de contratante para este usuário.");
        }

        UsuarioEntity usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        ContratanteEntity contratante = new ContratanteEntity(
                usuario,
                dto.getEmpresaOuRazaoSocial(),
                dto.getCpfOuCnpj(),
                dto.getEndereco()
        );

        return repository.save(contratante);
    }

    @Transactional(readOnly = true)
    public ContratanteEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contratante não encontrado."));
    }

    @Transactional(readOnly = true)
    public ContratanteEntity buscarPorUsuarioId(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Perfil de contratante não encontrado para este usuário."));
    }

    @Transactional(readOnly = true)
    public List<ContratanteEntity> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public ContratanteEntity atualizarPerfil(Long id, ContratanteDTO dto) {
        ContratanteEntity contratante = buscarPorId(id);

        contratante.setEmpresaOuRazaoSocial(dto.getEmpresaOuRazaoSocial());
        contratante.setCpfOuCnpj(dto.getCpfOuCnpj());
        contratante.setEndereco(dto.getEndereco());

        return repository.save(contratante);
    }
}