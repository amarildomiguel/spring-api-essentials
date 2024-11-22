package ucan.edu.sistema_academico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucan.edu.sistema_academico.entities.Disciplina;
import ucan.edu.sistema_academico.services.DisciplinaService;
import ucan.edu.sistema_academico.utils.ResponseBody;

import java.util.Optional;

@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinaController extends BaseController {

    @Autowired
    private DisciplinaService service;


    @GetMapping
    public ResponseEntity<ResponseBody> listar() {
        return this.ok("Lista", this.service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Integer id) {
        Optional<Disciplina> entidade = this.service.findById(id);
        if (entidade.isPresent())
            return this.ok("Encontrado com sucesso.", entidade.get());
        return this.naoEncontrado("Não encontrada.", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Disciplina entidade) {
        return this.created("Adicionado com sucesso.", this.service.create(entidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Integer id) {
        return this.ok("Eliminado com sucesso.", this.service.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Integer id, @RequestBody Disciplina entidade) {
        return this.ok("Editado com sucesso.", (Disciplina) service.update(id, entidade));
    }
}
