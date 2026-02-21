package com.example.biblioteca.mapper;

import com.example.biblioteca.dto.livro.LivroRequisicaoDTO;
import com.example.biblioteca.dto.livro.LivroRespostaDTO;
import com.example.biblioteca.dto.usuario.UsuarioRequisicaoDTO;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {


    public static Usuario paraEntidade(UsuarioRequisicaoDTO usuarioRequisicaoDTO) {
        return new Usuario(usuarioRequisicaoDTO.nome(),usuarioRequisicaoDTO.email());
    }


    public LivroRespostaDTO paraRespostaDTO(
            Livro livro) {
        return new LivroRespostaDTO(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getAno_publicacao());


    }

}
