package com.seuprojeto.cadastro.controller;

import com.seuprojeto.cadastro.model.Pessoa;
import com.seuprojeto.cadastro.repository.PessoaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @GetMapping("/{id}")
    public Pessoa buscarPorId(@PathVariable Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deletarPessoa(@PathVariable Long id) {
        if (pessoaRepository.existsById(id)) {
            pessoaRepository.deleteById(id);
            return "Pessoa removida com sucesso!";
        }
        return "Pessoa não encontrada!";
    }
}