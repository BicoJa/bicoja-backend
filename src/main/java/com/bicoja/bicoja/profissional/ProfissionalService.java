package com.bicoja.bicoja.profissional;

import com.bicoja.bicoja.usuario.UsuarioEntity;
import com.bicoja.bicoja.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfissionalService {

    private final ProfissionalRepository repository;
    private final UsuarioRepository usuarioRepository;

    public ProfissionalService(ProfissionalRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public ProfissionalEntity criarPerfil(ProfissionalDTO dto) {
        if (repository.existsByUsuarioId(dto.getUsuarioId())) {
            throw new IllegalStateException("Já existe um perfil de profissional para este usuário.");
        }

        UsuarioEntity usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        ProfissionalEntity profissional = new ProfissionalEntity(
                usuario,
                dto.getBiografia(),
                dto.getCpf(),
                dto.getCidade(),
                dto.getEstado()
        );

        return repository.save(profissional);
    }

    @Transactional(readOnly = true)
    public ProfissionalEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Profissional não encontrado."));
    }

    @Transactional(readOnly = true)
    public ProfissionalEntity buscarPorUsuarioId(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Perfil de profissional não encontrado para este usuário."));
    }

    @Transactional(readOnly = true)
    public List<ProfissionalEntity> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<ProfissionalEntity> buscarPorLocalizacao(String cidade, String estado) {
        return repository.findByCidadeIgnoreCaseAndEstadoIgnoreCase(cidade, estado);
    }

    @Transactional
    public ProfissionalEntity atualizarPerfil(Long id, ProfissionalDTO dto) {
        ProfissionalEntity profissional = buscarPorId(id);

        profissional.setBiografia(dto.getBiografia());
        profissional.setCpf(dto.getCpf());
        profissional.setCidade(dto.getCidade());
        profissional.setEstado(dto.getEstado());

        return repository.save(profissional);
    }
}