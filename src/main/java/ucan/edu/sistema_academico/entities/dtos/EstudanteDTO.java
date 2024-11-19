package ucan.edu.sistema_academico.entities.dtos;

import ucan.edu.sistema_academico.entities.Pessoa;

import java.time.LocalDate;

public record EstudanteDTO(String numeroEstudante, String nome, String numeroBi, LocalDate dataNascimento) {

    public Pessoa getPessoa() {
        return new Pessoa(null, nome, numeroBi, dataNascimento);
    }

}
