package com.bicoja.bicoja.vaga;

import com.bicoja.bicoja.contratante.ContratanteEntity;
import com.bicoja.bicoja.contratante.ContratanteRepository;
import com.bicoja.bicoja.habilidade.HabilidadeEntity;
import com.bicoja.bicoja.habilidade.HabilidadeRepository;

import com.bicoja.bicoja.profissionalhabilidade.ProfissionalHabilidadeEntity;
import com.bicoja.bicoja.profissionalhabilidade.ProfissionalHabilidadeRepository;
import com.bicoja.bicoja.vaga.dto.VagaRequestDTO;
import com.bicoja.bicoja.vaga.dto.VagaResponseDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VagaService {

    private final VagaRepository vagaRepository;
    private final ContratanteRepository contratanteRepository;
    private final HabilidadeRepository habilidadeRepository;
    private final ProfissionalHabilidadeRepository profissionalHabilidadeRepository;

    public VagaService(
            VagaRepository vagaRepository,
            ContratanteRepository contratanteRepository,
            HabilidadeRepository habilidadeRepository,
            ProfissionalHabilidadeRepository profissionalHabilidadeRepository) {

        this.vagaRepository = vagaRepository;
        this.contratanteRepository = contratanteRepository;
        this.habilidadeRepository = habilidadeRepository;
        this.profissionalHabilidadeRepository = profissionalHabilidadeRepository;
    }

    public void criarVaga(VagaRequestDTO dto) {

        // Busca o contratante
        ContratanteEntity contratante = contratanteRepository
                .findById(dto.idUsuario())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Contratante não encontrado."
                ));

        // Busca a habilidade
        HabilidadeEntity habilidade = habilidadeRepository
                .findByNome(dto.habilidade())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Habilidade não encontrada."
                ));

        // Monta a vaga
        VagaEntity vaga = new VagaEntity();

        vaga.setContratante(contratante);
        vaga.setHabilidade(habilidade);
        vaga.setTitulo(dto.titulo());
        vaga.setDescricao(dto.descricao());
        vaga.setEndereco(dto.endereco());

        // Salva no banco
        vagaRepository.save(vaga);
    }

    @Transactional(readOnly = true)
    public List<VagaResponseDTO> buscarVagasPorProfissional(Integer idUsuario) {

        // Busca as habilidades do profissional
        List<ProfissionalHabilidadeEntity> habilidades =
                profissionalHabilidadeRepository.
                        buscarPorIdUsuario(idUsuario);

        // Se não possuir habilidades, retorna uma lista vazia
        if (habilidades.isEmpty()) {
            return List.of();
        }

        // Extrai os IDs das habilidades
        List<Integer> habilidadesIds = habilidades.stream()
                .map(ph -> ph.getHabilidade().getId())
                .distinct()
                .toList();

        // Busca as vagas abertas que correspondem às habilidades
        return vagaRepository
                .findDistinctByHabilidade_IdInAndStatus(
                        habilidadesIds,
                        StatusVaga.ABERTA
                )
                .stream()
                .map(VagaResponseDTO::fromEntity)
                .toList();
    }

    @Transactional
    public void atualizarStatus(Integer idVaga, StatusVaga novoStatus) {

        VagaEntity vaga = vagaRepository.findById(idVaga)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Vaga não encontrada"
                ));

        if (vaga.getStatus() != StatusVaga.ABERTA) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Somente vagas abertas podem ser encerradas ou canceladas."
            );
        }

        switch (novoStatus) {

            case ENCERRADA ->
                    vaga.setDataConclusao(LocalDateTime.now());

            case CANCELADA ->
                    vaga.setDataCancelamento(LocalDateTime.now());

            default -> throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Status inválido."
            );
        }

        vaga.setStatus(novoStatus);

        vagaRepository.save(vaga);
    }

    @Transactional(readOnly = true)
    public List<VagaResponseDTO> buscarVagasPorContratante(
            Integer idUsuario,
            StatusVaga status) {

        return vagaRepository
                .buscarPorContratanteEStatus(idUsuario, status)
                .stream()
                .map(VagaResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }
}