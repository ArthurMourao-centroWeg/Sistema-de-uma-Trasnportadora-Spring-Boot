package com.inicio.CRUD.controller;

import com.inicio.CRUD.model.Frete;
import com.inicio.CRUD.service.FreteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frete")
public class FreteController {

    @Autowired
    private FreteService service;

    @PostMapping
    public ResponseEntity<?> salvarFrete(@Valid @RequestBody Frete frete){
        return new ResponseEntity<>(service.salvarFrete(frete), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> listarTodosFretes(){
        List<Frete> fretes = service.listarTodosFretes();
        return ResponseEntity.ok(fretes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarFretePorId(@PathVariable Long id){
        try {
            Frete frete = service.listarFretePorId(id);

            return ResponseEntity.ok(frete);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarFrete (@PathVariable Long id, @RequestBody Frete novoFrete){
        try {
            Frete freteAtualizado = service.atualizarFrete(id,novoFrete);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarFrete (@PathVariable Long id){
        try{
            service.deletarFrete(id);

            return ResponseEntity.ok("Deletado com Sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
