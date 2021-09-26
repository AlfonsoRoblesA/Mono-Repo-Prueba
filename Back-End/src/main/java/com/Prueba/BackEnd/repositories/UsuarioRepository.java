package com.Prueba.BackEnd.repositories;

import java.util.ArrayList;

import com.Prueba.BackEnd.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
    public abstract ArrayList<UsuarioModel> findByCorreo(String correo);
}
