package com.example.biblioteca.service;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.repository.EmprestimoRepository;

import java.sql.SQLException;

public class EmprestimoService {

    EmprestimoRepository emprestimoRepository = new EmprestimoRepository();

    public Emprestimo createEmprestimo(Emprestimo emprestimo) throws SQLException {
        return emprestimoRepository.createEmprestimo(emprestimo);
    }



}
