package br.edu.people.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import br.edu.people.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
    
}
