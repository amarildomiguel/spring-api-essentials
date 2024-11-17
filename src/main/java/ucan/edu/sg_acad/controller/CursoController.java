package ucan.edu.sg_acad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucan.edu.sg_acad.entities.Curso;
import ucan.edu.sg_acad.services.implementacao.CursoServiceImpl;
import ucan.edu.sg_acad.utils.ResponseBody;

import java.util.Optional;

@RestController
@RequestMapping(value = "/curso")
public class CursoController extends BaseController{
    @Autowired
    private CursoServiceImpl service;

    @GetMapping
    public ResponseEntity<ResponseBody> listar()
    {
        return this.ok("Lista", this.service.findAll() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Long id)
    {
        Optional<Curso> entidade = this.service.findById(id);
        if ( entidade.isPresent() )
            return this.ok("Encontrado com sucesso.", entidade.get());
        return this.naoEncontrado("Não encontrada.", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Curso entidade) {
        return this.created("Adicionado com sucesso.", this.service.criar(entidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Long id) {
        return this.ok("Eliminado com sucesso.", this.service.eliminar(id) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Long id, @RequestBody Curso entidade) {
        return this.ok("Editado com sucesso.", (Curso) service.editar(id, entidade));
    }
}
