package ucan.edu.sg_acad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucan.edu.sg_acad.entities.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}
