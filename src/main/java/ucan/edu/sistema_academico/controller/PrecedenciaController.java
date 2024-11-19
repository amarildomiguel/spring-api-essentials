package ucan.edu.sistema_academico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucan.edu.sistema_academico.entities.Precedencia;
import ucan.edu.sistema_academico.services.implementacao.PrecedenciaServiceImpl;
import ucan.edu.sistema_academico.utils.ResponseBody;

import java.util.Optional;

@RestController
@RequestMapping(value = "/precedencia")
public class PrecedenciaController extends BaseController {

    @Autowired
    private PrecedenciaServiceImpl service;

    @GetMapping("/disciplina/{id}")
    public ResponseEntity<ResponseBody> buscarPrecedenciasPorFkDisciplina(@PathVariable Long id) {
        return this.ok("Lista de precedencias por disciplina",
                this.service.buscarPrecedenciasPorFkDisciplina(id));
    }

    @GetMapping
    public ResponseEntity<ResponseBody> listar() {
        return this.ok("Lista", this.service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Long id) {
        Optional<Precedencia> entidade = this.service.findById(id);
        if (entidade.isPresent())
            return this.ok("Encontrado com sucesso.", entidade.get());
        return this.naoEncontrado("Não encontrada.", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Precedencia entidade) {
        return this.created("Adicionado com sucesso.", this.service.criar(entidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Long id) {
        return this.ok("Eliminado com sucesso.", this.service.eliminar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Long id, @RequestBody Precedencia entidade) {
        return this.ok("Editado com sucesso.", (Precedencia) service.editar(id, entidade));
    }
}
