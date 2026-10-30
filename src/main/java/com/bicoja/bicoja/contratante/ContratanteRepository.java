package com.bicoja.bicoja.contratante;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ContratanteRepository extends JpaRepository<ContratanteEntity, Long> {
    Optional<ContratanteEntity> findByCpfCnpj(String cpfCnpj);
}