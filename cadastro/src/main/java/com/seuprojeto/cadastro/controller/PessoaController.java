package com.seuprojeto.cadastro.controller;

import com.seuprojeto.cadastro.model.Pessoa;
import com.seuprojeto.cadastro.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin("*")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping
    public Pessoa criar(@RequestBody @Valid Pessoa pessoa) {
        return service.salvar(pessoa);
    }

    @GetMapping
    public List<Pessoa> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Pessoa buscar(@PathVariable Long id) {
        return service.buscarPorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Pessoa atualizar(@PathVariable Long id, @RequestBody @Valid Pessoa pessoa) {
        return service.atualizar(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}