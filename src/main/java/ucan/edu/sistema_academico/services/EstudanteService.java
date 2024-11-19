package ucan.edu.sistema_academico.services;

import ucan.edu.sistema_academico.entities.Estudante;
import ucan.edu.sistema_academico.entities.Pessoa;

public interface EstudanteService{
   Estudante criar(Estudante estudante, Pessoa pessoa);
   Estudante buscarPorNumeroEstudante(String numeroEstudante);
}
