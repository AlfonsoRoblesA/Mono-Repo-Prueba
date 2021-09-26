package com.Prueba.BackEnd.repositories;

import com.Prueba.BackEnd.models.PaisModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends CrudRepository<PaisModel, Integer>{
    
}
