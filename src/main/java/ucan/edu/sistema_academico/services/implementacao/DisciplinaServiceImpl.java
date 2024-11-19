package ucan.edu.sistema_academico.services.implementacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucan.edu.sistema_academico.entities.Disciplina;
import ucan.edu.sistema_academico.repositories.DisciplinaRepository;
import ucan.edu.sistema_academico.services.DisciplinaService;

import java.util.List;


@Service
public class DisciplinaServiceImpl extends AbstractService<Disciplina, Long> implements DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;

    @Override
    public List<Disciplina> buscarDisciplinasComPrecedencia() {
        return repository.findDisciplinasWithPrecedencia();
    }
}
