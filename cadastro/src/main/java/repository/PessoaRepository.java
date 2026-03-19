package com.seuprojeto.cadastro.repository;

import com.seuprojeto.cadastro.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}