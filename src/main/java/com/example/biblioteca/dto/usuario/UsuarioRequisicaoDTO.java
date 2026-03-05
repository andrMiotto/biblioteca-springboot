package com.example.biblioteca.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequisicaoDTO(
        @NotBlank(message = "Nome deve ser preenchido")
        String nome,
        @NotBlank(message = "Email deve ser preenchido")
        @Email(message = "Email deve ser preenchido corretamente")
        String email
        ) {

}
