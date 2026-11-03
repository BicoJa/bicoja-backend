package com.bicoja.bicoja.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {

    @Id
    private Integer id_usuario;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, length = 255)
    private String senha;
}