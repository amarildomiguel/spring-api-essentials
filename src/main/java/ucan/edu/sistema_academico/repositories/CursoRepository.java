package ucan.edu.sistema_academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucan.edu.sistema_academico.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
