package com.example.biblioteca.controller;


import com.example.biblioteca.dto.usuario.UsuarioRequisicaoDTO;
import com.example.biblioteca.dto.usuario.UsuarioRespostaDTO;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public UsuarioRespostaDTO createUser(@RequestBody UsuarioRequisicaoDTO usuarioRequisicaoDTO) throws SQLException {

        return usuarioService.createUsuario(usuarioRequisicaoDTO);

    }

    @GetMapping("/listarTodos")
    public List<UsuarioRespostaDTO> listAllUsuarios() throws SQLException {

        return usuarioService.listAll();

    }


    @GetMapping("/listarId/{id}")
    public UsuarioRespostaDTO listUsuarioID(@PathVariable("id") int id) throws SQLException {
        return usuarioService.listUsuarioId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deleteUsuarioId(@PathVariable("id") int id) throws SQLException {
        usuarioService.deleteUsuario(id);
    }

    @PutMapping("/atualizar/{id}")
    public UsuarioRespostaDTO atualizar(@PathVariable int id, @RequestBody UsuarioRequisicaoDTO usuarioRequisicaoDTO) throws SQLException {
        return usuarioService.updateUsuario(usuarioRequisicaoDTO,id);
    }

}
