package com.example.biblioteca.dto.emprestimo;

import java.time.LocalDate;
import java.util.Date;

public record EmprestimoRequisicaoDTO(
        int livro_id,
        int usuario_id,
        Date data_emprestimo,
        Date data_devolucao
) {


}
