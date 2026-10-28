package com.bicoja.bicoja.contratante;

import com.bicoja.bicoja.usuario.UsuarioEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTRATANTE")
public class ContratanteEntity {

    @Id
    private Integer id_usuario;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    public ContratanteEntity() {
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

}
