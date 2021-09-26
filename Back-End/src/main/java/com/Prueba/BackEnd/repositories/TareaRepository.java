package com.Prueba.BackEnd.repositories;

import com.Prueba.BackEnd.models.TareaModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends CrudRepository<TareaModel, Integer> {
    
}
