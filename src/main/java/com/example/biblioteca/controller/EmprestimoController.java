package com.example.biblioteca.controller;

import com.example.biblioteca.dto.emprestimo.EmprestimoRequisicaoDTO;
import com.example.biblioteca.dto.emprestimo.EmprestimoRespostaDTO;
import com.example.biblioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping
    public EmprestimoRespostaDTO createLivro(@RequestBody EmprestimoRequisicaoDTO emprestimoRequisicaoDTO) throws SQLException {
        return emprestimoService.createEmprestimo(emprestimoRequisicaoDTO);
    }


    @GetMapping("/listarTodos")
    public List<EmprestimoRespostaDTO> listAllEmprestimos() throws SQLException {

        return emprestimoService.listAllEmprestimo();

    }


    @GetMapping("/listarId/{id}")
    public EmprestimoRespostaDTO listEmprestimoId(@PathVariable("id") int id) throws SQLException {
        return emprestimoService.listEmprestimoId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deleteEmprestimoId(@PathVariable("id") int id) throws SQLException {
        emprestimoService.deleteEmprestimo(id);
    }

    @PutMapping("/atualizar/{id}")
    public EmprestimoRespostaDTO atualizarEmprestimo(@PathVariable int id, @RequestBody EmprestimoRequisicaoDTO emprestimoRequisicaoDTO) throws SQLException {
        return emprestimoService.updateEmprestimo(emprestimoRequisicaoDTO, id);
    }

}
