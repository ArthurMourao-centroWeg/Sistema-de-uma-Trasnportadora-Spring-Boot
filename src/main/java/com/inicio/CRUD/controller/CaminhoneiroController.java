package com.inicio.CRUD.controller;


import com.inicio.CRUD.model.Caminhoneiro;
import com.inicio.CRUD.service.CaminhoneiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caminhoneiros")
public class CaminhoneiroController {
    @Autowired
    private CaminhoneiroService service;

    @PostMapping
    public ResponseEntity<Caminhoneiro> criar(@Valid @RequestBody Caminhoneiro caminhoneiro){
        return new ResponseEntity<>(service.salvarCaminhoneiro(caminhoneiro), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Caminhoneiro> listarTodosCaminhoneiros(){
        return service.listarTodosCaminhoneiros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPeloId(@PathVariable Long id){
        try{
            service.listarCaminhoneiroPorId(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            System.out.println("ID NÃO ENCONTRADO " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCaminhoneiro(@PathVariable Long id, @RequestBody Caminhoneiro dados ){
        try {
            service.atualizarCaminhoneiro(id, dados);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            System.out.println("ID NÃO ENCONTRADO " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCaminhoneiro(@PathVariable Long id){
        try{
            service.deletarCaminhoneiro(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            System.out.println("ID NÃO ENCONTRADO " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
