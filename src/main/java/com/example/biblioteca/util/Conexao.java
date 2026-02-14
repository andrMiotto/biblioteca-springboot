package com.example.biblioteca.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexao {

    private static String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static String USER = "root";
    private static String SENHA = "";


    public static Connection conectar ()throws SQLException{
        return DriverManager.getConnection(URL, USER, SENHA);
    }

}
