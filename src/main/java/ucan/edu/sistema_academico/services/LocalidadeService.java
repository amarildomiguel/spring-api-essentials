package ucan.edu.sistema_academico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucan.edu.sistema_academico.entities.Localidade;
import ucan.edu.sistema_academico.repositories.LocalidadeRepository;

@Service
public class LocalidadeService extends AbstractService<Localidade, Integer> {

    @Autowired
    private LocalidadeRepository localidadeRepository;

    public Localidade findByNome(String nome) {
        return localidadeRepository.findByNome(nome);
    }
}
