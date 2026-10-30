package com.bicoja.bicoja.profissional;

import com.bicoja.bicoja.usuario.UsuarioEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_profissionais")
public class ProfissionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private UsuarioEntity usuario;

    @Column(columnDefinition = "TEXT")
    private String biografia;

    private String cpf;

    private String cidade;

    private String estado;

    private Double notaMedia = 0.0;

    public ProfissionalEntity() {}

    public ProfissionalEntity(UsuarioEntity usuario, String biografia, String cpf, String cidade, String estado) {
        this.usuario = usuario;
        this.biografia = biografia;
        this.cpf = cpf;
        this.cidade = cidade;
        this.estado = estado;
        this.notaMedia = 0.0;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UsuarioEntity getUsuario() { return usuario; }
    public void setUsuario(UsuarioEntity usuario) { this.usuario = usuario; }

    public String getBiografia() { return biografia; }
    public void setBiografia(String biografia) { this.biografia = biografia; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Double getNotaMedia() { return notaMedia; }
    public void setNotaMedia(Double notaMedia) { this.notaMedia = notaMedia; }
}