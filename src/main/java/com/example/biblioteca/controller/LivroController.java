package com.example.biblioteca.controller;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.service.LivroService;
import com.example.biblioteca.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/livro")
public class LivroController {


    LivroService livroService =  new LivroService();

    @PostMapping
    public Livro createLivro(@RequestBody Livro livro) throws SQLException {

        return livroService.createLivro(livro);

    }

    @GetMapping("/listarTodos")
    public List<Livro> listAllLivros() throws SQLException {

        return livroService.listAllLivro();

    }


    @GetMapping("/listarId/{id}")
    public Livro listLivroId(@PathVariable("id") int id) throws SQLException {
        return livroService.listLivroId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deleteLivroId(@PathVariable("id") int id) throws SQLException {
        livroService.deleteLivro(id);
    }

    @PutMapping("/atualizar/{id}")
    public void atualizarLivro(@PathVariable int id, @RequestBody Livro livro) throws SQLException {
        livroService.updateLivro(livro,id);
    }
}
