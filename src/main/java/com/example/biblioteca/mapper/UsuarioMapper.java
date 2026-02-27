package com.example.biblioteca.mapper;

import com.example.biblioteca.dto.livro.LivroRespostaDTO;
import com.example.biblioteca.dto.usuario.UsuarioRequisicaoDTO;
import com.example.biblioteca.dto.usuario.UsuarioRespostaDTO;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {


    public static Usuario paraEntidade(UsuarioRequisicaoDTO usuarioRequisicaoDTO) {
        return new Usuario(usuarioRequisicaoDTO.nome(), usuarioRequisicaoDTO.email());
    }


    public UsuarioRespostaDTO paraRespostaDTO(
            Usuario usuario) {
        return new UsuarioRespostaDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());


    }

}
