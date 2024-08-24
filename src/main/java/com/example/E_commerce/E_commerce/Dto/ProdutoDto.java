package com.example.E_commerce.E_commerce.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProdutoDto(
        @NotBlank
        String nome,

        String descricaDoProduto,

        @NotNull
        double valor,

        @NotNull
        int quantidades
) {



}
