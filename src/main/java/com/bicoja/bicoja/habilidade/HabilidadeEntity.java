package com.bicoja.bicoja.habilidade;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "HABILIDADE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabilidadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 100)
    private String nome;

}
