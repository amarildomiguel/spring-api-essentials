package ucan.edu.sistema_academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucan.edu.sistema_academico.entities.Disciplina;

import java.util.List;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

    // listar quais são as disciplinas que possuem precedência
    @Query("SELECT d FROM disciplinas d WHERE d.pkDisciplina IN (SELECT p.fkDisciplina.pkDisciplina FROM precendencia p)")
    List<Disciplina> findDisciplinasWithPrecedencia();

}
