package com.bicoja.bicoja.contratante;

import com.bicoja.bicoja.usuario.UsuarioEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_contratantes")
public class ContratanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private UsuarioEntity usuario;

    private String empresaOuRazaoSocial;

    private String cpfOuCnpj;

    private String endereco;

    public ContratanteEntity() {}

    public ContratanteEntity(UsuarioEntity usuario, String empresaOuRazaoSocial, String cpfOuCnpj, String endereco) {
        this.usuario = usuario;
        this.empresaOuRazaoSocial = empresaOuRazaoSocial;
        this.cpfOuCnpj = cpfOuCnpj;
        this.endereco = endereco;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UsuarioEntity getUsuario() { return usuario; }
    public void setUsuario(UsuarioEntity usuario) { this.usuario = usuario; }

    public String getEmpresaOuRazaoSocial() { return empresaOuRazaoSocial; }
    public void setEmpresaOuRazaoSocial(String empresaOuRazaoSocial) { this.empresaOuRazaoSocial = empresaOuRazaoSocial; }

    public String getCpfOuCnpj() { return cpfOuCnpj; }
    public void setCpfOuCnpj(String cpfOuCnpj) { this.cpfOuCnpj = cpfOuCnpj; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
}