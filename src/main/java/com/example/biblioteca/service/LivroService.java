package com.example.biblioteca.service;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.LivroRepository;
import com.example.biblioteca.repository.UsuarioRepository;

import java.sql.SQLException;
import java.util.List;

public class LivroService {

    LivroRepository livroRepository = new LivroRepository();
    public Livro createLivro(Livro livro)throws SQLException {
        return livroRepository.createLivro(livro);
    }

    public List<Livro> listAllLivro()throws SQLException {
        return livroRepository.listAllLivro();
    }
    public Livro listLivroId(int id)throws SQLException {
        return livroRepository.listLivroId(id);
    }
    public void deleteLivro(int id)throws SQLException {
        livroRepository.deleteLivro(id);
    }
    public Livro updateLivro(Livro livro, int id)throws SQLException {
        return livroRepository.updateLivro(livro,id);
    }





}
