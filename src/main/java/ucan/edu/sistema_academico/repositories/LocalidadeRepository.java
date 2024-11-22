package ucan.edu.sistema_academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucan.edu.sistema_academico.entities.Localidade;

import java.util.List;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Integer> {
    Localidade findByNome(String nome);

    List<Localidade> findAllByOrderByNomeAsc();

    List<Localidade> findByFkLocalidadePai(Localidade fkLocalidadePai);

}
