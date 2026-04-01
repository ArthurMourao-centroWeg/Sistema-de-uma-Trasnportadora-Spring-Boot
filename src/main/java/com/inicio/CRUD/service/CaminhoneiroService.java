package com.inicio.CRUD.service;

import com.inicio.CRUD.model.Caminhoneiro;
import com.inicio.CRUD.repository.CaminhoneiroRepository;
import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaminhoneiroService {

    @Autowired
    private CaminhoneiroRepository repository;

    public Caminhoneiro salvarCaminhoneiro(Caminhoneiro caminhoneiro){
        if (repository.existsByCpf(caminhoneiro.getCpf())==true){
            System.out.println("Já existe um caminhoneiro com esse nome");
            throw new RuntimeException();
        }
        return repository.save(caminhoneiro);
    }

    public Caminhoneiro atualizarCaminhoneiro(Long id, Caminhoneiro novoCaminhoneiro){
        Caminhoneiro existente = listarCaminhoneiroPorId(id);
        if (novoCaminhoneiro.getNome()!=null){
            existente.setNome(novoCaminhoneiro.getNome());
        }
        if (novoCaminhoneiro.getCpf()!=null){
            existente.setCpf(novoCaminhoneiro.getCpf());
        }
        if (novoCaminhoneiro.getCnh()!=null){
            existente.setCnh(novoCaminhoneiro.getCnh());
        }
        if (novoCaminhoneiro.getPlacaVeiculo()!=null){
            existente.setCnh(novoCaminhoneiro.getPlacaVeiculo());
        }
        return repository.save(existente);
    }

    public List<Caminhoneiro> listarTodosCaminhoneiros(){
        return repository.findAll();
    }

    public Caminhoneiro listarCaminhoneiroPorId (Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Caminhoneiro não encontrado"));
    }

    public void deletarCaminhoneiro (Long id) throws RuntimeException{
        Caminhoneiro caminhoneiro = listarCaminhoneiroPorId(id);
        repository.delete(caminhoneiro);
    }
}
