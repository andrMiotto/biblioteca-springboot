package com.example.biblioteca.service;

import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository = new UsuarioRepository();
    public Usuario createUsuario(Usuario usuario)throws SQLException{
        return usuarioRepository.createUsuario(usuario);
    }

    public List<Usuario> listAll()throws SQLException{
        return usuarioRepository.listAllUsuario();
    }
    public Usuario listUsuarioId(int id)throws SQLException{
        return usuarioRepository.listUsuarioId(id);
    }
    public Usuario deleteUsuario(int id)throws SQLException{
        return usuarioRepository.deleteUser(id);
    }
    public Usuario updateUsuario(Usuario usuario, int id)throws SQLException{
        return usuarioRepository.updateUser(usuario,id);
    }

}
