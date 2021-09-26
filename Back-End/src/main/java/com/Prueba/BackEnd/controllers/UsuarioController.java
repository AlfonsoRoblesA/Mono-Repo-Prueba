package com.Prueba.BackEnd.controllers;

import com.Prueba.BackEnd.models.UsuarioModel;
import com.Prueba.BackEnd.services.UsuarioService;
import com.Prueba.BackEnd.utils.Mensaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping(path = "/getAll")
    public Mensaje obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping(path = "/registrar")
    public Mensaje registrarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.registrarUsuario(usuario);
    }

    @PostMapping(path = "/iniciarSesion")
    public Mensaje IniciarSesion(@RequestBody UsuarioModel usuario){
        return this.usuarioService.iniciarSesion(usuario);
    }

}
