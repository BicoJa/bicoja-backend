package com.bicoja.bicoja.profissional;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProfissionalRepository extends JpaRepository<ProfissionalEntity, Long> {
    Optional<ProfissionalEntity> findByCpf(String cpf);
    Optional<ProfissionalEntity> findByTelefone(String telefone);
}