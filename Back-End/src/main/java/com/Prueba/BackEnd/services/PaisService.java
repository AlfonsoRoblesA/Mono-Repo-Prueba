package com.Prueba.BackEnd.services;

import java.util.ArrayList;

import com.Prueba.BackEnd.models.PaisModel;
import com.Prueba.BackEnd.repositories.PaisRepository;
import com.Prueba.BackEnd.utils.Mensaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {
    @Autowired
    PaisRepository paisRepository;

    public Mensaje obtenerPaises(){
        Mensaje msj = new Mensaje();
        ArrayList<PaisModel> listaPaises = null;
        try {
            listaPaises = (ArrayList<PaisModel>) paisRepository.findAll();
        } catch (Exception e) {
            msj.setError(true);
            msj.setMensaje("Error al conectar a la base de datos");
            return msj;
        }
        if (listaPaises == null || listaPaises.size() < 1) {
            msj.setError(true);
            msj.setMensaje("No hay paises en la base de datos");
        } else {
            msj.setError(false);
            msj.setMensaje("Solicitud correcta");
            msj.setListaPaises(listaPaises);
        }
        return msj;
    }
}
