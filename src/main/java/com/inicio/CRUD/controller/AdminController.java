package com.inicio.CRUD.controller;

import com.inicio.CRUD.model.Admin;
import com.inicio.CRUD.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController{

    @Autowired
    AdminService service;

    @PostMapping("")
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
        service.listarAdmin();
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(Long id){
        try{
            service.listarAdminPorId(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            System.out.println("ID não encontrado " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

}
