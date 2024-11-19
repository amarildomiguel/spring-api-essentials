package ucan.edu.sistema_academico.services;

import ucan.edu.sistema_academico.entities.Disciplina;
import ucan.edu.sistema_academico.entities.PlanoCurso;

import java.util.List;

public interface PlanoCursoService {

    List<Disciplina> buscarDisciplinasDoPlanodeCursoPeloFkCurso(Long fkCurso);

    List<PlanoCurso> buscarPlanoCursoAgrupadoPorSemestre(Long fkCurso);
}
