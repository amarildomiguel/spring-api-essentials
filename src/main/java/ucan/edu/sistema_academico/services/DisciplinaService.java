package ucan.edu.sistema_academico.services;

import ucan.edu.sistema_academico.entities.Disciplina;

import java.util.List;

public interface DisciplinaService {
    List<Disciplina> buscarDisciplinasComPrecedencia();
}
