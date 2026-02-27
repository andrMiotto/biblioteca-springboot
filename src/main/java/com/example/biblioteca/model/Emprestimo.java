package com.example.biblioteca.model;

import java.time.LocalDate;
import java.util.Date;

public class Emprestimo {

    int id;
    int livro_id;
    int usuario_id;
    Date data_emprestimo;
    Date data_devolucao;

    public Emprestimo(int id, int livro_id, int usuario_id, Date data_emprestimo, Date data_devolucao) {
        this.id = id;
        this.livro_id = livro_id;
        this.usuario_id = usuario_id;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public Emprestimo(int livro_id, int usuario_id, Date data_emprestimo, Date data_devolucao) {
        this.livro_id = livro_id;
        this.usuario_id = usuario_id;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(int livro_id) {
        this.livro_id = livro_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }


    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", livro_id=" + livro_id +
                ", usuario_id=" + usuario_id +
                ", data_emprestimo=" + data_emprestimo +
                ", data_devolucao=" + data_devolucao +
                '}';
    }
}
