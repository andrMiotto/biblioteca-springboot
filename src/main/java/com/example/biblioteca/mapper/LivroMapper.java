package com.example.biblioteca.mapper;

import com.example.biblioteca.dto.livro.LivroRequisicaoDTO;
import com.example.biblioteca.dto.livro.LivroRespostaDTO;
import com.example.biblioteca.model.Livro;
import org.springframework.stereotype.Component;


@Component
public class LivroMapper {


    public static Livro paraEntidade(LivroRequisicaoDTO livroRequisicaoDTO) {
        return new Livro(livroRequisicaoDTO.titulo(), livroRequisicaoDTO.autor(), livroRequisicaoDTO.ano_publicacao());
    }


    public LivroRespostaDTO paraRespostaDTO(
            Livro livro) {
        return new LivroRespostaDTO(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getAno_publicacao());


    }

}
