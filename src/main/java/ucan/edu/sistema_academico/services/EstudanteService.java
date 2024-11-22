package ucan.edu.sistema_academico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ucan.edu.sistema_academico.entities.Estudante;
import ucan.edu.sistema_academico.repositories.EstudanteRepository;
import ucan.edu.sistema_academico.utils.LatencyUtils;

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
        LatencyUtils.simulateLatency(2); // simular latencia de 2s
        return repository.findById(id);
    }
}
