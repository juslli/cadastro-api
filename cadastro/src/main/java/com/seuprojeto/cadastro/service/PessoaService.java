package com.seuprojeto.cadastro.service;

import com.seuprojeto.cadastro.model.Pessoa;
import com.seuprojeto.cadastro.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa criar(Pessoa pessoa) {
        Optional<Pessoa> pessoaExistente = pessoaRepository.findByEmail(pessoa.getEmail());

        if (pessoaExistente.isPresent()) {
            throw new RuntimeException("Já existe uma pessoa cadastrada com esse email.");
        }

        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> atualizar(Long id, Pessoa dadosAtualizados) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

        if (pessoaOptional.isEmpty()) {
            return Optional.empty();
        }

        Pessoa pessoa = pessoaOptional.get();
        pessoa.setNome(dadosAtualizados.getNome());
        pessoa.setEmail(dadosAtualizados.getEmail());

        return Optional.of(pessoaRepository.save(pessoa));
    }

    public boolean deletar(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

        if (pessoaOptional.isEmpty()) {
            return false;
        }

        pessoaRepository.deleteById(id);
        return true;
    }
}