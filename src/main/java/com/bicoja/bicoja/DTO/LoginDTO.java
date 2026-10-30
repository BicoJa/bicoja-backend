package com.bicoja.bicoja.usuario;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO {
    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}