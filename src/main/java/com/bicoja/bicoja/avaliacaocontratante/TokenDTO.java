package com.bicoja.bicoja.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import java.util.List;

public class LoginDTO {
    @NotBlank(message = "O telefone é obrigatório.")
    private String telefone;

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}

public class CadastroDTO {
    @NotBlank(message = "O nome completo é obrigatório.")
    private String nomeCompleto;

    @NotBlank(message = "O telefone é obrigatório.")
    private String telefone;

    @NotEmpty(message = "Selecione ao menos um serviço.")
    private List<String> servicos;

    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public List<String> servicos() { return servicos; }
    public List<String> getServicos() { return servicos; }
    public void setServicos(List<String> servicos) { this.servicos = servicos; }
}

public class ValidarTokenDTO {
    @NotBlank(message = "O telefone é obrigatório.")
    private String telefone;

    @NotBlank(message = "O código token é obrigatório.")
    @Pattern(regexp = "^\\d{4}$", message = "O token deve conter exatamente 4 dígitos.")
    private String token;

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}