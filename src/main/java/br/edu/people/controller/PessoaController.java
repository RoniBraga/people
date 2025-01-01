package br.edu.people.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.people.dto.PessoaRecordDto;
import br.edu.people.model.Pessoa;
import br.edu.people.repository.PessoaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    PessoaRepository pessoaRepository;

    @PostMapping
    public  ResponseEntity<Pessoa>  salvarPessoa(@RequestBody @Valid PessoaRecordDto PessoaRecordDto){
        var Pessoa = new Pessoa();
        // converte DTO para model Pessoa
        BeanUtils.copyProperties(PessoaRecordDto, Pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaRepository.save(Pessoa));

    }
    @GetMapping
    public ResponseEntity<List<Pessoa>> listAllPessoas(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPessoa(@PathVariable(value = "id") UUID id){
        Optional<Pessoa> ps = pessoaRepository.findById(id);
        if(ps.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não existe");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ps.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarPessoa(@PathVariable(value = "id") UUID id, @RequestBody @Valid PessoaRecordDto pessoaRecordDto){
        Optional<Pessoa> ps = pessoaRepository.findById(id);

        if(ps.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não existe");
        }
        var pessoa = ps.get();
        BeanUtils.copyProperties(pessoaRecordDto, pessoa);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaRepository.save(pessoa));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirPessoa(@PathVariable(value = "id") UUID id){
        Optional<Pessoa> ps = pessoaRepository.findById(id);
        if(ps.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não existe");
        }
        pessoaRepository.delete(ps.get());
        return ResponseEntity.status(HttpStatus.OK).body("pessoa excluída com sucesso");
    }
   
}
