package br.com.meteora.api.model.produto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarProduto (
   
    @NotNull Long id,
    String nome,
    String tamanho,
    String modelo,
    String cor
    ) {

    }






