package com.bicoja.bicoja.fototrabalho;

import com.bicoja.bicoja.profissional.ProfissionalEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "FOTO_TRABALHO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FotoTrabalhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long profissionalId;

}
