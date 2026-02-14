package com.example.biblioteca.controller;


import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    UsuarioService usuarioService =  new UsuarioService();

    @PostMapping
    public Usuario createUser(@RequestBody Usuario usuario) throws SQLException {

        return usuarioService.createUsuario(usuario);

    }

    @GetMapping("/listarTodos")
    public List<Usuario> listAllUsuarios() throws SQLException {

        return usuarioService.listAll();

    }


    @GetMapping("/listarId/{id}")
    public Usuario listUsuarioID(@PathVariable("id") int id) throws SQLException {
        return usuarioService.listUsuarioId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deleteUsuarioId(@PathVariable("id") int id) throws SQLException {
        usuarioService.deleteUsuario(id);
    }

    @PutMapping("/atualizar/{id}")
    public void atualizar(@PathVariable int id, @RequestBody Usuario usuario) throws SQLException {
        usuarioService.updateUsuario(usuario,id);
    }

}
