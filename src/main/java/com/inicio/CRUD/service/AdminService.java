package com.inicio.CRUD.service;

import com.inicio.CRUD.model.Admin;
import com.inicio.CRUD.model.Caminhoneiro;
import com.inicio.CRUD.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    public Admin salvarAdmin (Admin admin){
        return repository.save(admin);
    }
    public List<Admin> listarAdmin (){
        return repository.findAll();
    }
    public Admin listarAdminPorId (Long id){
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
    public void deletar(Long id){
        Admin admin = listarAdminPorId(id);
        repository.delete(admin);
    }
    public void atualizar(Long id, Admin novoAdmin){
        Admin existente = listarAdminPorId(id);

        if (novoAdmin.getNome()!=null){
            existente.setNome(novoAdmin.getNome());
        }
        if (novoAdmin.getEmail()!=null){
            existente.setEmail(novoAdmin.getEmail());
        }
        repository.save(existente);
    }


}
