package com.example.biblioteca.service;

import com.example.biblioteca.dto.livro.LivroRequisicaoDTO;
import com.example.biblioteca.dto.livro.LivroRespostaDTO;
import com.example.biblioteca.mapper.LivroMapper;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;

import java.sql.SQLException;
import java.util.List;

public class LivroService {

    private final LivroRepository livroRepository;
    private final LivroMapper livroMapper;

    public LivroService(LivroRepository livroRepository, LivroMapper livroMapper) {
        this.livroRepository = livroRepository;
        this.livroMapper = livroMapper;
    }

    public LivroRespostaDTO createLivro(LivroRequisicaoDTO livroRequisicaoDTO) throws SQLException {
        Livro livro = livroMapper.paraEntidade(livroRequisicaoDTO);
        return livroMapper.paraRespostaDTO( livroRepository.createLivro(livro));
    }

    public List<Livro> listAllLivro() throws SQLException {
        return livroRepository.listAllLivro();
    }

    public Livro listLivroId(int id) throws SQLException {
        return livroRepository.listLivroId(id);
    }

    public void deleteLivro(int id) throws SQLException {
        livroRepository.deleteLivro(id);
    }

    public Livro updateLivro(Livro livro, int id) throws SQLException {
        return livroRepository.updateLivro(livro, id);
    }


}
