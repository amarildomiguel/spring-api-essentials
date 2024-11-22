package ucan.edu.sistema_academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucan.edu.sistema_academico.entities.Estudante;

import java.util.List;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {
    List<Estudante> findAllByOrderByNomeAsc();

    Estudante findByNumeroEstudante(String numeroEstudante);
}
