package ucan.edu.sistema_academico.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucan.edu.sistema_academico.entities.Localidade;
import ucan.edu.sistema_academico.repositories.LocalidadeRepository;

import java.util.*;

@Service
public class LocalidadeService extends AbstractService<Localidade, Integer> {

    @Autowired
    private LocalidadeRepository localidadeRepository;

    private Map<Integer, Localidade> localidadeCache = new HashMap<>();
    private static List<Localidade> localidadesAngolanas = new ArrayList<>();

    @PostConstruct
    public void init() {
        localidadeRepository.findAll().forEach(
                localidade ->
                        localidadeCache.put(localidade.getPkLocalidade(), localidade));

        criarLocalidadesAngolanas();
    }

    public Localidade findByNome(String nome) {
        return localidadeCache.values().stream().filter(
                localidade ->
                        localidade.getNome().equals(nome)).findFirst().orElse(null);
    }

    @Override
    public List<Localidade> findAll() {
        if (localidadeCache.isEmpty()) {
            reloadCache();
        }
        return localidadeCache.values().stream().toList();
    }

    @Override
    public Optional<Localidade> findById(Integer pkLocalidade) {
        if (localidadeCache.isEmpty()) {
            reloadCache();
        }
        return localidadeCache.get(pkLocalidade) != null ?
                Optional.of(localidadeCache.get(pkLocalidade)) : Optional.empty();
    }

    @Override
    public Localidade create(Localidade localidade) {
        Localidade localidadeCriada = super.create(localidade);
        localidadeCache.put(localidadeCriada.getPkLocalidade(), localidadeCriada);
        return localidadeCriada;
    }

    @Override
    public Localidade update(Integer pkLocalidade, Localidade localidade) {
        Localidade localidadeAtualizada = super.update(pkLocalidade, localidade);
        localidadeCache.put(pkLocalidade, localidadeAtualizada);
        return localidadeAtualizada;
    }

    @Override
    public Localidade delete(Integer pkLocalidade) {
        Localidade localidadeDeletada = super.delete(pkLocalidade);
        localidadeCache.remove(pkLocalidade);
        return localidadeDeletada;
    }


    public void reloadCache() {
        localidadeCache.clear();
        localidadeRepository.findAll().forEach(
                localidade -> localidadeCache.put(localidade.getPkLocalidade(), localidade)
        );
    }

    private void criarLocalidadesAngolanas() {
        // Find Angola first
        Localidade angola = localidadeRepository.findByNome("Angola");

        if (angola != null) {
            // Find all localities where Angola is the parent
            localidadesAngolanas = localidadeRepository.findByFkLocalidadePai(angola);
        }
    }

    public Localidade escolherAleatoriamenteLocalidadeAngolana() {
        if (localidadesAngolanas.isEmpty()) {
            criarLocalidadesAngolanas(); // Reload if empty
        }

        int size = localidadesAngolanas.size();
        int posicao = (int) (Math.random() * size);
        return localidadesAngolanas.get(posicao);
    }

}
