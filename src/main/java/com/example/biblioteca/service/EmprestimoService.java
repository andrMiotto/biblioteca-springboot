package com.example.biblioteca.service;

import com.example.biblioteca.dto.emprestimo.EmprestimoRequisicaoDTO;
import com.example.biblioteca.dto.emprestimo.EmprestimoRespostaDTO;
import com.example.biblioteca.dto.livro.LivroRequisicaoDTO;
import com.example.biblioteca.dto.livro.LivroRespostaDTO;
import com.example.biblioteca.mapper.EmprestimoMapper;
import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;

    private final EmprestimoMapper emprestimoMapper;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, EmprestimoMapper emprestimoMapper) {
        this.emprestimoRepository = emprestimoRepository;
        this.emprestimoMapper = emprestimoMapper;
    }

    public EmprestimoRespostaDTO createEmprestimo(EmprestimoRequisicaoDTO emprestimoRequisicaoDTO) throws SQLException {
        Emprestimo emprestimo = emprestimoMapper.paraEntidade(emprestimoRequisicaoDTO);
        Emprestimo salvo =  emprestimoRepository.createEmprestimo(emprestimo);

        return emprestimoMapper.paraRespostaDTO(salvo);
    }

    public List<EmprestimoRespostaDTO> listAllEmprestimo() throws SQLException {
        List<Emprestimo> emprestimos = emprestimoRepository.listAllEmprestimos();

        return emprestimos.stream()
                .map(emprestimoMapper::paraRespostaDTO)
                .toList();
    }

    public EmprestimoRespostaDTO listEmprestimoId(int id) throws SQLException {
        Emprestimo emprestimo = emprestimoRepository.listEmprestimoById(id);
        return emprestimoMapper.paraRespostaDTO(emprestimo);
    }

    public void deleteEmprestimo(int id) throws SQLException {
        emprestimoRepository.deleteEmprestimo(id);
    }

    public EmprestimoRespostaDTO updateEmprestimo(EmprestimoRequisicaoDTO emprestimoRequisicaoDTO, int id) throws SQLException {
        Emprestimo emprestimo = emprestimoMapper.paraEntidade(emprestimoRequisicaoDTO);
        emprestimo.setId(id);

        Emprestimo salvo = emprestimoRepository.updateEmprestimo(emprestimo, emprestimo.getId());
        return emprestimoMapper.paraRespostaDTO(salvo);
    }

}
