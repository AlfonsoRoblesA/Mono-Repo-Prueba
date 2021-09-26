package com.Prueba.BackEnd.controllers;

import com.Prueba.BackEnd.services.PaisService;
import com.Prueba.BackEnd.utils.Mensaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pais")
public class PaisController {
    @Autowired
    PaisService paisService;

    @GetMapping(path = "/getAll")
    public Mensaje obtenerUsuarios(){
        return paisService.obtenerPaises();
    }
}
