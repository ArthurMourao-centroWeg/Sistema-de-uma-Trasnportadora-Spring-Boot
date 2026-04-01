package com.inicio.CRUD.controller;

import com.inicio.CRUD.model.Frete;
import com.inicio.CRUD.service.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frete")
public class FreteController {

    @Autowired
    private FreteService service;

    public ResponseEntity<Frete> salvarFrete(@RequestBody Frete frete){
        return new ResponseEntity<>(service.salvarFrete(frete), HttpStatus.CREATED);
    }

}
