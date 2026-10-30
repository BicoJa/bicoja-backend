package com.bicoja.bicoja.vaga;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class VagaDTO {

    @NotNull(message = "O ID do contratante é obrigatório.")
    private Long contratanteId;

    @NotBlank(message = "O título da vaga é obrigatório.")
    private String titulo;

    @NotBlank(message = "A descrição da vaga é obrigatória.")
    private String descricao;

    @NotBlank(message = "A categoria do serviço é obrigatória.")
    private String categoria;

    @NotNull(message = "O valor oferecido é obrigatório.")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero.")
    private BigDecimal valorOferecido;

    @NotBlank(message = "A cidade é obrigatória.")
    private String cidade;

    @NotBlank(message = "O estado é obrigatório.")
    private String estado;

    public Long getContratanteId() { return contratanteId; }
    public void setContratanteId(Long contratanteId) { this.contratanteId = contratanteId; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public BigDecimal getValorOferecido() { return valorOferecido; }
    public void setValorOferecido(BigDecimal valorOferecido) { this.valorOferecido = valorOferecido; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}