package ucan.edu.sistema_academico.entities.dtos;

import java.time.LocalDate;

public record EstudanteDTO(String numeroEstudante, String nome, String numeroBi, LocalDate dataNascimento) {

}
