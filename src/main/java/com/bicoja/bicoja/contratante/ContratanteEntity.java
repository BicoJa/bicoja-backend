package com.bicoja.bicoja.contratante;

import com.bicoja.bicoja.usuario.UsuarioEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "CONTRATANTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratanteEntity {

    @Id
    private Integer id_usuario;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

}
