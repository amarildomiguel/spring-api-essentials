package ucan.edu.sistema_academico.services.implementacao;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class AbstractService<ENTIDADE, CHAVE> {

    @Autowired
    protected JpaRepository<ENTIDADE, CHAVE> repository;

    public Repository<ENTIDADE, CHAVE> getRepository() {
        return repository;
    }

    public List<ENTIDADE> findAll() {
        return this.repository.findAll();
    }

    public Page<ENTIDADE> findPagina(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Optional<ENTIDADE> findById(CHAVE id) {
        return this.repository.findById(id);
    }

    public ENTIDADE criar(ENTIDADE entidade) {
        if (entidade == null)
            throw new NullPointerException("Entidade a ser registrada está nula.");
        return this.repository.save(entidade);
    }

    public ENTIDADE editar(CHAVE id, ENTIDADE entidade) {
        if (this.findById(id).isEmpty())
            throw new EntityNotFoundException("Não foi possível encontrar o registro.");
        return this.repository.save(entidade);
    }

    public ENTIDADE eliminar(CHAVE id) {
        Optional<ENTIDADE> entidade = this.findById(id);
        if (entidade.isEmpty())
            return entidade.orElse(null);
        this.repository.deleteById(id);
        return entidade.get();
    }
}
