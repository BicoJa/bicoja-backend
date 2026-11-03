package com.bicoja.bicoja.profissional;

import com.bicoja.bicoja.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "profissional")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfissionalEntity {

    @Id
    private Integer id_usuario;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;
}