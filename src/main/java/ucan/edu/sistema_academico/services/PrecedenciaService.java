package ucan.edu.sistema_academico.services;


import org.springframework.data.repository.query.Param;
import ucan.edu.sistema_academico.entities.Precedencia;

import java.util.List;

public interface PrecedenciaService {
    List<Precedencia> buscarPrecedenciasPorFkDisciplina(Long fkDisciplina);
}
