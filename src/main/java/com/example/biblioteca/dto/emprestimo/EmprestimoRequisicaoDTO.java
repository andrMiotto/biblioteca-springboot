package com.example.biblioteca.dto.emprestimo;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record EmprestimoRequisicaoDTO(
        @NotNull(message = "Livro ID deve ser preenchido")
        int livro_id,
        @NotNull(message = "Usuario ID deve ser preenchido")
        int usuario_id,

        Date data_emprestimo,
        @Future(message = "Data de devolução precisa ser no futuro")
        Date data_devolucao
) {


}
