package ucan.edu.sistema_academico.services.implementacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucan.edu.sistema_academico.entities.Disciplina;
import ucan.edu.sistema_academico.entities.PlanoCurso;
import ucan.edu.sistema_academico.repositories.PlanoCursoRepository;
import ucan.edu.sistema_academico.services.PlanoCursoService;

import java.util.List;

@Service
public class PlanoCursoServiceImpl extends AbstractService<PlanoCurso, Long> implements PlanoCursoService {

    @Autowired
    PlanoCursoRepository repository;

    public List<Disciplina> buscarDisciplinasDoPlanodeCursoPeloFkCurso(Long fkCurso) {
        return repository.findDisciplinasByCursoId(fkCurso);
    }

    public List<PlanoCurso> buscarPlanoCursoAgrupadoPorSemestre(Long cursoId) {
        return repository.findByCursoPkCursoOrderBySemestre(cursoId);
    }

}
