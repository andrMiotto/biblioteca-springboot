package com.example.biblioteca.service;

import com.example.biblioteca.dto.livro.LivroRequisicaoDTO;
import com.example.biblioteca.dto.livro.LivroRespostaDTO;
import com.example.biblioteca.mapper.LivroMapper;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final LivroMapper livroMapper;

    public LivroService(LivroRepository livroRepository, LivroMapper livroMapper) {
        this.livroRepository = livroRepository;
        this.livroMapper = livroMapper;
    }

    public LivroRespostaDTO createLivro(LivroRequisicaoDTO livroRequisicaoDTO) throws SQLException {
        Livro livro = livroMapper.paraEntidade(livroRequisicaoDTO);
        Livro salvo = livroRepository.createLivro(livro);
        return livroMapper.paraRespostaDTO(salvo);
    }

    public List<LivroRespostaDTO> listAllLivro() throws SQLException {
        List<Livro> livros = livroRepository.listAllLivro();

        return livros.stream()
                .map(livroMapper::paraRespostaDTO)
                .toList();
    }

    public LivroRespostaDTO listLivroId(int id) throws SQLException {
        Livro livro = livroRepository.listLivroId(id);
        return livroMapper.paraRespostaDTO(livro);
    }

    public void deleteLivro(int id) throws SQLException {
        livroRepository.deleteLivro(id);
    }

    public Livro updateLivro(Livro livro, int id) throws SQLException {
        return livroRepository.updateLivro(livro, id);
    }


}
