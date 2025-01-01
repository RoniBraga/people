package br.edu.people.dto;

import jakarta.validation.constraints.NotBlank;

public record PessoaRecordDto(@NotBlank String nome, @NotBlank String email, long telefone) {
    
}
