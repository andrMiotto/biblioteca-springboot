package com.example.biblioteca.dto.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroRequisicaoDTO(
        @NotBlank(message = "Titulo deve ser preenchido")
        String titulo,
        @NotBlank(message = "Autor deve ser preenchido")
        String autor,
        int ano_publicacao




) {





}
