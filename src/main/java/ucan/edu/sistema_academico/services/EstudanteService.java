package ucan.edu.sistema_academico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ucan.edu.sistema_academico.entities.Estudante;
import ucan.edu.sistema_academico.repositories.EstudanteRepository;

import java.util.List;
import java.util.Optional;


@Service
public class EstudanteService extends AbstractService<Estudante, Integer> {

    @Autowired
    EstudanteRepository repository;


    List<Estudante> findAllByOrderByNomeAsc() {
        return repository.findAllByOrderByNomeAsc();
    }

    @Override
    @Cacheable("estudante_cache")
    public Optional<Estudante> findById(Integer id) {
        return repository.findById(id);
    }

    private void simulateLatency() {
        try {
            long time = 1000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
