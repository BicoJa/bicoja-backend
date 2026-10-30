package com.bicoja.bicoja.vaga;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VagaService {

    private final VagaRepository repository;

    public VagaService(VagaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public VagaEntity publicarVaga(VagaDTO dto) {
        VagaEntity vaga = new VagaEntity(
                dto.getContratanteId(),
                dto.getTitulo(),
                dto.getDescricao(),
                dto.getCategoria(),
                dto.getValorOferecido(),
                dto.getCidade(),
                dto.getEstado()
        );
        return repository.save(vaga);
    }

    @Transactional(readOnly = true)
    public List<VagaEntity> listarVagasAbertas() {
        return repository.findByStatusOrderByDataCriacaoDesc(VagaEntity.StatusVaga.ABERTA);
    }

    @Transactional(readOnly = true)
    public VagaEntity buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vaga não encontrada."));
    }

    @Transactional(readOnly = true)
    public List<VagaEntity> listarPorContratante(Long contratanteId) {
        return repository.findByContratanteIdOrderByDataCriacaoDesc(contratanteId);
    }

    @Transactional(readOnly = true)
    public List<VagaEntity> buscarPorCategoria(String categoria) {
        return repository.findByCategoriaAndStatus(categoria, VagaEntity.StatusVaga.ABERTA);
    }

    @Transactional(readOnly = true)
    public List<VagaEntity> buscarPorLocalizacao(String cidade, String estado) {
        return repository.findByCidadeIgnoreCaseAndEstadoIgnoreCaseAndStatus(cidade, estado, VagaEntity.StatusVaga.ABERTA);
    }

    @Transactional
    public VagaEntity atualizarStatus(Long id, VagaEntity.StatusVaga novoStatus) {
        VagaEntity vaga = buscarPorId(id);
        vaga.setStatus(novoStatus);
        return repository.save(vaga);
    }

    @Transactional
    public void cancelarVaga(Long id) {
        VagaEntity vaga = buscarPorId(id);
        vaga.setStatus(VagaEntity.StatusVaga.CANCELADA);
        repository.save(vaga);
    }
}