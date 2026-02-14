package com.example.biblioteca.repository;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.util.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LivroRepository {


    public Livro createLivro(Livro livro) throws SQLException {

        String query = "INSERT INTO livro (titulo, autor,ano_publicacao) VALUES (?,?,?)";


        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {


            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno_publicacao());


            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                livro.setId(rs.getInt(1));
            }

        }

        return livro;
    }

    public List<Livro> listAllLivro() throws SQLException {

        String query = "SELECT id,titulo,autor,ano_publicacao FROM livro";


        List<Livro> livros = new ArrayList<>();

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {


            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int ano_publicacao = rs.getInt("ano_publicacao");


                Livro livro = new Livro(id, titulo, autor, ano_publicacao);
                livros.add(livro);
            }
        }

        return livros;
    }

    public Livro listLivroId(int id) throws SQLException {

        String query = "SELECT id,titulo,autor,ano_publicacao FROM livro where id = ?";


        List<Livro> livros = new ArrayList<>();

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int ano_publicacao = rs.getInt("ano_publicacao");

                return new Livro(id, titulo, autor, ano_publicacao);
            }
        }
        return null;
    }


    public void deleteLivro(int id) throws SQLException {

        String query = "DELETE FROM livro where id = ?";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);

        }

    }


    public Livro updateLivro(Livro livro, int id) throws SQLException {
        String query = "UPDATE livro SET titulo = ?, autor = ?, ano_publicacao = ? WHERE id = ?";


        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno_publicacao());
            stmt.setLong(4, id);

            stmt.executeUpdate();
        }


        return livro;
    }

}
