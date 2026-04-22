package com.inicio.CRUD.controller;

import com.inicio.CRUD.model.Admin;
import com.inicio.CRUD.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController{

    @Autowired
    AdminService service;

    @PostMapping
    public ResponseEntity<?> salvarAdmin(@Valid @RequestBody Admin admin){
        try{
            service.salvarAdmin(admin);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            System.out.println("Erro " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<?> listarTodos(){
         List<Admin> lista = service.listarAdmin();
         return ResponseEntity.ok().body(lista);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        try{
            Admin admin = service.listarAdminPorId(id);
            return ResponseEntity.ok().body(admin);
        } catch (RuntimeException e) {
            System.out.println("ID não encontrado " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.ok().body("Deletado com Sucesso!");
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Admin admin){
        service.atualizar(id,admin);
        return ResponseEntity.ok().body("Atualizado com o sucesso");
    }

}
