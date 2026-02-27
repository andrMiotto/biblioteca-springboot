package com.example.biblioteca.service;

import com.example.biblioteca.dto.usuario.UsuarioRequisicaoDTO;
import com.example.biblioteca.dto.usuario.UsuarioRespostaDTO;
import com.example.biblioteca.mapper.UsuarioMapper;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioRespostaDTO createUsuario(UsuarioRequisicaoDTO usuarioRequisicaoDTO) throws SQLException {
        Usuario usuario = usuarioMapper.paraEntidade(usuarioRequisicaoDTO);
        Usuario salvo = usuarioRepository.createUsuario(usuario);
        return usuarioMapper.paraRespostaDTO(salvo);
    }

    public List<UsuarioRespostaDTO> listAll() throws SQLException {
        List<Usuario> usuarios = usuarioRepository.listAllUsuario();

        return usuarios.stream()
                .map(usuarioMapper::paraRespostaDTO)
                .toList();
    }

    public UsuarioRespostaDTO listUsuarioId(int id) throws SQLException {
        Usuario usuario = usuarioRepository.listUsuarioId(id);
        return usuarioMapper.paraRespostaDTO(usuario);

    }

    public Usuario deleteUsuario(int id) throws SQLException {
        return usuarioRepository.deleteUser(id);
    }

    public UsuarioRespostaDTO updateUsuario(UsuarioRequisicaoDTO usuarioRequisicaoDTO, int id) throws SQLException {
        Usuario usuario = usuarioMapper.paraEntidade(usuarioRequisicaoDTO);
        usuario.setId(id);
        Usuario salvo = usuarioRepository.updateUser(usuario, usuario.getId());
        return usuarioMapper.paraRespostaDTO(salvo);
    }

}
