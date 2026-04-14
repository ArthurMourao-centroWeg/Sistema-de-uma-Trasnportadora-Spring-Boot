package com.inicio.CRUD.service;

import com.inicio.CRUD.model.Frete;
import com.inicio.CRUD.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreteService {
    @Autowired
    FreteRepository repository;

    public Frete salvarFrete (Frete frete){
        return repository.save(frete);
    }

    public List<Frete> listarTodosFretes(){
        return repository.findAll();
    }

    public Frete listarFretePorId(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Caminhoneiro não encontrado"));
    }

    public Frete atualizarFrete (Long id, Frete novoFrete){
        Frete existente = listarFretePorId(id);
        if (novoFrete.getValor() != existente.getValor()){
            existente.setValor(novoFrete.getValor());
        }
        if (novoFrete.getStatus() != null){
            existente.setStatus(novoFrete.getStatus());
        }
        if (novoFrete.getOrigem()!= null){
            existente.setOrigem(novoFrete.getOrigem());
        }
        if (novoFrete.getDestino() != null){
            existente.setDestino(novoFrete.getDestino());
        }
        if (novoFrete.getCaminhoneiro() != null){
            existente.setCaminhoneiro(novoFrete.getCaminhoneiro());
        }
        if (novoFrete.getAdmin() != null){
            existente.setAdmin(novoFrete.getAdmin());
        }
        return repository.save(existente);
    }

    public void deletarFrete(Long id){
        Frete frete = listarFretePorId(id);
        repository.delete(frete);
    }
}
