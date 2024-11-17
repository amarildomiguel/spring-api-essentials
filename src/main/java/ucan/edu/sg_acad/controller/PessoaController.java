
package ucan.edu.sg_acad.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucan.edu.sg_acad.entities.Pessoa;
import ucan.edu.sg_acad.services.implementacao.PessoaServiceImpl;
import ucan.edu.sg_acad.utils.ResponseBody;

import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController extends BaseController{
    @Autowired
    private PessoaServiceImpl service;

    @GetMapping
    public ResponseEntity<ResponseBody> listar()
    {
        return this.ok("Pessoas Listados com sucesso.", this.service.findAll() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable Long id)
    {
        Optional<Pessoa> pessoa = this.service.findById(id);
        if ( pessoa.isPresent() )
            return this.ok("Pessoa encontrada com sucesso.", pessoa.get());
        return this.naoEncontrado("Pessoa não encontrada.", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Pessoa pessoa) {
        return this.created("Pessoa adicionado com sucesso.", this.service.criar(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") Long id) {
        return this.ok("Pessoa eliminado com sucesso.", this.service.eliminar(id) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") Long id, @RequestBody Pessoa paciente) {
        return this.ok("Pessoa editado com sucesso.", (Pessoa) service.editar(id, paciente));
    }
}
