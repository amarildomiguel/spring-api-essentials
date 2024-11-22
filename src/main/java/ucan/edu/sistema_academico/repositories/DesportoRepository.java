package ucan.edu.sistema_academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ucan.edu.sistema_academico.entities.Desporto;
import ucan.edu.sistema_academico.entities.Estudante;

import java.util.List;

public interface DesportoRepository extends JpaRepository<Desporto, Integer> {

    @Query("SELECT e FROM estudantes e JOIN e.desportosPracticados d WHERE d.nome = :nomeDesporto")
    List<Estudante> findEstudantesByDesporto(@Param("nomeDesporto") String nomeDesporto);
}
