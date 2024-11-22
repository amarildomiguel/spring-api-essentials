package ucan.edu.sistema_academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucan.edu.sistema_academico.entities.Disciplina;
import ucan.edu.sistema_academico.entities.PlanoCurso;

import java.util.List;

@Repository
public interface PlanoCursoRepository extends JpaRepository<PlanoCurso, Integer> {

    // listar disciplinas de um curso
    @Query("SELECT p.disciplina FROM plano_curso p WHERE p.curso.pkCurso = :cursoId")
    List<Disciplina> findDisciplinasByCursoId(Integer cursoId);

    List<PlanoCurso> findByCursoPkCursoOrderBySemestre(Integer cursoId);

}