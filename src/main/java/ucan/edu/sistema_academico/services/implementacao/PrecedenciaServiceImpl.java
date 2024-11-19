package ucan.edu.sistema_academico.services.implementacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucan.edu.sistema_academico.entities.Precedencia;
import ucan.edu.sistema_academico.repositories.PrecendenciaRepository;
import ucan.edu.sistema_academico.services.PrecedenciaService;

import java.util.List;

@Service
public class PrecedenciaServiceImpl extends AbstractService<Precedencia, Long> implements PrecedenciaService {

    @Autowired
    private PrecendenciaRepository repository;

    @Override
    public List<Precedencia> buscarPrecedenciasPorFkDisciplina(Long fkDisciplina) {
        return repository.findPrecedenciasByFkDisciplina(fkDisciplina);
    }
}
