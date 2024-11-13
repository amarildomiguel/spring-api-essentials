/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucan.Clinica.controllers;

import com.ucan.Clinica.bootloader.ServidorBootLoader;
import com.ucan.Clinica.entities.Pessoa;
import com.ucan.Clinica.utils.ResponseBody;
import com.ucan.Clinica.services.implementacao.PessoaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("pessoa")
public class PessoaController extends BaseController{
    private static Logger LOGGER = LoggerFactory.getLogger(ServidorBootLoader.class);
    @Autowired
    private PessoaServiceImpl service;

    @GetMapping
    public ResponseEntity<ResponseBody> listar() 
    {
        return this.ok("Pessoas Listados com sucesso.", this.service.findAll() );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody> obter(@PathVariable UUID id) 
    {
        Optional<Pessoa> pessoa = this.service.findById(id);
        if ( pessoa.isPresent() )
            return this.ok("Pessoa encontrada com sucesso.", pessoa.get());
        return this.naoEncontrado("Pessoa não encontrada.", null);
    }

    @PostMapping
    public ResponseEntity<ResponseBody> criar(@RequestBody Pessoa pessoa) {
        System.out.println(pessoa.getNome());
        return this.created("Pessoa adicionado com sucesso.", this.service.criar(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> eliminar(@PathVariable("id") UUID id) {
        return this.ok("Pessoa eliminado com sucesso.", this.service.eliminar(id) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> editar(@PathVariable("id") UUID id, @RequestBody Pessoa paciente) {
        return this.ok("Pessoa editado com sucesso.", (Pessoa) service.editar(id, paciente));
    }
}
