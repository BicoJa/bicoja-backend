package com.bicoja.bicoja.usuario;

import jakarta.validation.constraints.NotBlank;

public class ValidarTokenDTO {
    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "O token é obrigatório")
    private String token;

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}