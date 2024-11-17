package ucan.edu.sg_acad.entities.dtos;

import ucan.edu.sg_acad.entities.Pessoa;

import java.time.LocalDate;

public record EstudanteDTO(String numeroEstudante, String nome, String numeroBi, LocalDate dataNascimento) {

    public Pessoa getPessoa() {
        return new Pessoa(null, nome, numeroBi, dataNascimento);
    }

}
