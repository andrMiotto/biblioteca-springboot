package com.example.biblioteca.controller;

import com.example.biblioteca.dto.livro.LivroRequisicaoDTO;
import com.example.biblioteca.dto.livro.LivroRespostaDTO;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public LivroRespostaDTO createLivro(@RequestBody LivroRequisicaoDTO livroRequisicaoDTO) throws SQLException {
        return livroService.createLivro(livroRequisicaoDTO);
    }

    @GetMapping("/listarTodos")
    public List<LivroRespostaDTO> listAllLivros() throws SQLException {

        return livroService.listAllLivro();

    }


    @GetMapping("/listarId/{id}")
    public LivroRespostaDTO listLivroId(@PathVariable("id") int id) throws SQLException {
        return livroService.listLivroId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deleteLivroId(@PathVariable("id") int id) throws SQLException {
        livroService.deleteLivro(id);
    }
/*
    @PutMapping("/atualizar/{id}")
    public void atualizarLivro(@PathVariable int id, @RequestBody Livro livro) throws SQLException {
        livroService.updateLivro(livro,id);
    }*/
}
