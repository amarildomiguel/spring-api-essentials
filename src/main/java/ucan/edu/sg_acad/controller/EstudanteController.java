package ucan.edu.sg_acad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucan.edu.sg_acad.entities.Estudante;
import ucan.edu.sg_acad.entities.dtos.EstudanteDTO;
import ucan.edu.sg_acad.services.implementacao.EstudanteServiceImpl;
import ucan.edu.sg_acad.utils.ResponseBody;

import java.util.Optional;

@RestController
@RequestMapping("/estudante")
public class EstudanteController extends BaseController{

    @Autowired
    private EstudanteServiceImpl service;

    @GetMapping
    public ResponseEntity<ResponseBody> listar()
    {
        return this.ok("Lista", this.service.findAll() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Long id)
    {
        Optional<Estudante> entidade = this.service.findById(id);
        if ( entidade.isPresent() )
            return this.ok("Encontrado com sucesso.", entidade.get());
        return this.naoEncontrado("Não encontrada.", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Estudante entidade) {
        return this.created("Adicionado com sucesso.", this.service.criar(entidade, entidade.getPessoa()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Long id) {
        return this.ok("Eliminado com sucesso.", this.service.eliminar(id) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Long id, @RequestBody Estudante entidade) {
        return this.ok("Editado com sucesso.", (Estudante) service.editar(id, entidade));
    }
}
