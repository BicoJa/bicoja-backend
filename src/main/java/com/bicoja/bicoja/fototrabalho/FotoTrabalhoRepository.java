package com.bicoja.bicoja.fototrabalho;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FotoTrabalhoRepository extends JpaRepository<FotoTrabalhoEntity, Long> {

    List<FotoTrabalhoEntity> findByProfissionalId(Long profissionalId);
}