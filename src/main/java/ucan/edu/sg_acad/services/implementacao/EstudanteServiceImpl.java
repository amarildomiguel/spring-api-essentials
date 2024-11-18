package ucan.edu.sg_acad.services.implementacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucan.edu.sg_acad.entities.Estudante;
import ucan.edu.sg_acad.entities.Pessoa;
import ucan.edu.sg_acad.repositories.EstudanteRepository;
import ucan.edu.sg_acad.repositories.PessoaRepository;
import ucan.edu.sg_acad.services.EstudanteService;


@Service
public class EstudanteServiceImpl extends AbstractService<Estudante, Long> implements EstudanteService{

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

    public Estudante buscarPorNumeroEstudante(String numeroEstudante) {
        return estudanteRepository.findByNumeroEstudante(numeroEstudante);
    }


}
