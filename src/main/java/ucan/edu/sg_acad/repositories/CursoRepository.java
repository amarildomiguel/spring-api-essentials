package ucan.edu.sg_acad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucan.edu.sg_acad.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
