package com.example.biblioteca.repository;

import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.util.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {


    public Usuario createUsuario(Usuario usuario) throws SQLException {

        String query = "INSERT INTO usuario (nome, email) VALUES (?,?)";


        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {


            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getEmail());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                usuario.setId(rs.getInt(1));
            }

        }

        return usuario;
    }

    public List<Usuario> listAllUsuario() throws SQLException {

        String query = "SELECT id,nome,email FROM usuario";


        List<Usuario> usuarios = new ArrayList<>();

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {


            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");


                Usuario usuario = new Usuario(id, nome, email);
                usuarios.add(usuario);
            }
        }

        return usuarios;
    }

    public Usuario listUsuarioId(Usuario usuario) throws SQLException {

        String query = "SELECT id,nome,email FROM usuario where id = ?";


        List<Usuario> usuarios = new ArrayList<>();

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, usuario.getId());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                return new Usuario(id, nome, email);
            }
        }
        return null;
    }


    public void deleteUser(int id)throws SQLException{

        String query = "DELETE FROM usuario where id = ?";

        try(Connection connection = Conexao.conectar();
        PreparedStatement stmt = connection.prepareStatement(query)){

            stmt.setInt(1,id);

        }

    }



    public void updateUser(Usuario usuario)throws SQLException{
        String query = "UPDATE usuario SET nome,email VALUES (?,?)";


        try(Connection connection = Conexao.conectar();
        PreparedStatement stmt = connection.prepareStatement(query)){

            stmt.setLong(1, usuario.getId());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getEmail());

            stmt.executeUpdate();
        }




    }


}
