package com.seuprojeto.cadastro.service;

import com.seuprojeto.cadastro.model.Pessoa;
import com.seuprojeto.cadastro.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa salvar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public List<Pessoa> listarTodas() {
        return repository.findAll();
    }

    public Optional<Pessoa> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Pessoa atualizar(Long id, Pessoa pessoaAtualizada) {
        return repository.findById(id).map(pessoa -> {
            pessoa.setNome(pessoaAtualizada.getNome());
            pessoa.setEmail(pessoaAtualizada.getEmail());
            return repository.save(pessoa);
        }).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}