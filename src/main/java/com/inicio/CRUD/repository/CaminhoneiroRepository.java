package com.inicio.CRUD.repository;

import com.inicio.CRUD.model.Caminhoneiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaminhoneiroRepository extends JpaRepository<Caminhoneiro,Long> {
    boolean existsByCpf (String cpf);
}
