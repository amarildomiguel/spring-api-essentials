package ucan.edu.sg_acad.services;

import ucan.edu.sg_acad.entities.Estudante;
import ucan.edu.sg_acad.entities.Pessoa;

public interface EstudanteService{
   Estudante criar(Estudante estudante, Pessoa pessoa);
   Estudante buscarPorNumeroEstudante(String numeroEstudante);
}
