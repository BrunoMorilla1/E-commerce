package com.example.E_commerce.E_commerce.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDto(
        @NotBlank
        String nome,

        @NotNull
        double valor,

        @NotNull
        int quantidades,

        String descricaDoProduto){
}