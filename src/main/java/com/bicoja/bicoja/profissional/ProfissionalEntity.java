package com.bicoja.bicoja.profissional;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_profissionais")
public class ProfissionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

    @ElementCollection
    @CollectionTable(name = "tb_profissional_habilidades", joinColumns = @JoinColumn(name = "profissional_id"))
    @Column(name = "habilidade")
    private List<String> habilidades;

    public ProfissionalEntity() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<String> getHabilidades() { return habilidades; }
    public void setHabilidades(List<String> habilidades) { this.habilidades = habilidades; }
}