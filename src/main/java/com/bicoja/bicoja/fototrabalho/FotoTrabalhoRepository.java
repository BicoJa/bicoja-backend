package com.bicoja.bicoja.fototrabalho;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FotoTrabalhoRepository extends JpaRepository<FotoTrabalhoEntity, Long> {
    List<FotoTrabalhoEntity> findByProfissionalId(Long profissionalId);
}