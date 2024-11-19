package ucan.edu.sistema_academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucan.edu.sistema_academico.entities.Precedencia;

import java.util.List;

@Repository
public interface PrecendenciaRepository extends JpaRepository<Precedencia, Long> {

    // listar as precedencias de uma determinada disciplina indicada por parameto
    @Query("SELECT p FROM precendencia p WHERE p.fkDisciplina.pkDisciplina = :disciplinaId")
    List<Precedencia> findPrecedenciasByFkDisciplina(@Param("disciplinaId") Long disciplinaId);

}
