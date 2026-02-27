package com.example.biblioteca.dto.emprestimo;

import java.util.Date;

public record EmprestimoRespostaDTO(
        int id,
        int livro_id,
        int usuario_id,
        Date data_emprestimo,
        Date data_devolucao


) {


}
