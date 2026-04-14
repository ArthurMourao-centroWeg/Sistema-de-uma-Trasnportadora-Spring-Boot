package com.inicio.CRUD.repository;

import com.inicio.CRUD.model.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository <Frete,Long> {

}
