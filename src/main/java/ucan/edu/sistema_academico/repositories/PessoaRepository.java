package ucan.edu.sistema_academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucan.edu.sistema_academico.entities.Pessoa;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByNome(String nome);
    Pessoa findByNumeroBi(String numeroBi);
    List<Pessoa> findByDataNascimento(LocalDate dataNascimento);

}
