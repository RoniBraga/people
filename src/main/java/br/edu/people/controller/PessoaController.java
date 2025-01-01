package br.edu.people.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.people.dto.PessoaRecordDto;
import br.edu.people.model.Pessoa;
import br.edu.people.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    PessoaRepository pessoaRepository;

    @PostMapping
    public  ResponseEntity<Pessoa>  salvarPessoa(@RequestBody PessoaRecordDto PessoaRecordDto){
        var Pessoa = new Pessoa();
        // converte DTO para model Pessoa
        BeanUtils.copyProperties(PessoaRecordDto, Pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaRepository.save(Pessoa));

    }

   
}
