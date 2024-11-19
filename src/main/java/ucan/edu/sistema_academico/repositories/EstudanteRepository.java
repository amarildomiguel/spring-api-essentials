package ucan.edu.sistema_academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucan.edu.sistema_academico.entities.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    Estudante findByNumeroEstudante(String numeroEstudante);

}
