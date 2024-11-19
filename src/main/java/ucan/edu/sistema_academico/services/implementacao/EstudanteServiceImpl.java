package ucan.edu.sistema_academico.services.implementacao;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucan.edu.sistema_academico.entities.Estudante;
import ucan.edu.sistema_academico.entities.Pessoa;
import ucan.edu.sistema_academico.repositories.EstudanteRepository;
import ucan.edu.sistema_academico.repositories.PessoaRepository;
import ucan.edu.sistema_academico.services.EstudanteService;

import java.util.Optional;


@Service
public class EstudanteServiceImpl extends AbstractService<Estudante, Long> implements EstudanteService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    public Estudante criar(Estudante estudante, Pessoa pessoa) {
        if (estudante == null || pessoa == null)
            throw new NullPointerException("Entidade a ser registrada está nula.");
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        estudante.setPessoa(pessoaSalva);
        return estudanteRepository.save(estudante);
    }

    @Override
    public Estudante editar(Long id, Estudante entidade) {
        Optional<Estudante> estudanteExistente = estudanteRepository.findById(id);
        if (estudanteExistente.isPresent()) {
            Estudante estudanteAtualizado = estudanteExistente.get();
            estudanteAtualizado.setPessoa(
                    entidade.getPessoa() != null ? entidade.getPessoa() : estudanteAtualizado.getPessoa()
            );
            return estudanteRepository.save(estudanteAtualizado);
        } else {
            throw new EntityNotFoundException("Estudante não encontrado");
        }
    }

    public Estudante buscarPorNumeroEstudante(String numeroEstudante) {
        return estudanteRepository.findByNumeroEstudante(numeroEstudante);
    }
}
