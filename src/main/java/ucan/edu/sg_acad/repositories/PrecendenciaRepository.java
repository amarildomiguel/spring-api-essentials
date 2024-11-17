package ucan.edu.sg_acad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucan.edu.sg_acad.entities.Precedencia;

@Repository
public interface PrecendenciaRepository extends JpaRepository<Precedencia, Long> {

}
