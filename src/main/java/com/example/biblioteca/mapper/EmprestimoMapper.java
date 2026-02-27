package com.example.biblioteca.mapper;

import com.example.biblioteca.dto.emprestimo.EmprestimoRequisicaoDTO;
import com.example.biblioteca.dto.emprestimo.EmprestimoRespostaDTO;
import com.example.biblioteca.dto.livro.LivroRequisicaoDTO;
import com.example.biblioteca.dto.livro.LivroRespostaDTO;
import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoMapper {

    public Emprestimo paraEntidade(EmprestimoRequisicaoDTO emprestimoRequisicaoDTO) {
        return new Emprestimo(emprestimoRequisicaoDTO.livro_id(),emprestimoRequisicaoDTO.usuario_id(),emprestimoRequisicaoDTO.data_emprestimo(),emprestimoRequisicaoDTO.data_devolucao());
    }


    public EmprestimoRespostaDTO paraRespostaDTO(Emprestimo emprestimo) {
        return new EmprestimoRespostaDTO(emprestimo.getId(), emprestimo.getLivro_id(),emprestimo.getUsuario_id(),emprestimo.getData_emprestimo(),emprestimo.getData_devolucao());


    }


}
