package com.bicoja.bicoja.notificacao;

import com.bicoja.bicoja.usuario.UsuarioEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "NOTIFICACAO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

}
