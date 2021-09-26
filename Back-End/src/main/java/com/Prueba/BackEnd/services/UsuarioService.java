package com.Prueba.BackEnd.services;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.Prueba.BackEnd.models.UsuarioModel;
import com.Prueba.BackEnd.repositories.UsuarioRepository;
import com.Prueba.BackEnd.utils.Mensaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Mensaje obtenerUsuarios() {
        Mensaje msj = new Mensaje();
        ArrayList<UsuarioModel> listaUsuarios = null;
        try {
            listaUsuarios = (ArrayList<UsuarioModel>) usuarioRepository.findAll();
        } catch (Exception e) {
            msj.setError(true);
            msj.setMensaje("Error al conectar a la base de datos");
            return msj;
        }
        if (listaUsuarios == null || listaUsuarios.size() < 1) {
            msj.setError(true);
            msj.setMensaje("No hay usuarios en la base de datos");
        } else {
            msj.setError(false);
            msj.setMensaje("Solicitud correcta");
            msj.setListaUsarios(listaUsuarios);
        }
        return msj;
    }

    public Mensaje iniciarSesion(UsuarioModel userWeb) {
        Mensaje msj = new Mensaje();
        ArrayList<UsuarioModel> listaUsuarios = null;

        try {
            listaUsuarios = usuarioRepository.findByCorreo(userWeb.getCorreo());
        } catch (Exception e) {
            msj.setError(true);
            msj.setMensaje("Error al conectar a la base de datos");
            return msj;
        }

        if (listaUsuarios.size() < 1) {
            msj.setError(true);
            msj.setMensaje("No hay un usuario registrado con ese correo");
            return msj;
        }
        UsuarioModel usuario = listaUsuarios.get(0);

        if (usuario.getContrasena().equals(userWeb.getContrasena())) {
            msj.setError(false);
            msj.setMensaje("Inicio de sesion correcto");
            msj.setUsuario(usuario);
            Timestamp tiempoLogIn = new Timestamp(System.currentTimeMillis());
            usuario.setTiempUltimoLogin(tiempoLogIn);
            usuarioRepository.save(usuario);
        } else {
            msj.setError(true);
            msj.setMensaje("La contrasena no corresponde");
        }

        return msj;
    }

    // This method update the user when sign in
    public Mensaje registrarUsuario(UsuarioModel usuario) {
        ArrayList<UsuarioModel> listaUsuarios = usuarioRepository.findByCorreo(usuario.getCorreo());
        Mensaje msj = new Mensaje();
        if (listaUsuarios.size() > 0) {
            msj.setError(true);
            msj.setMensaje("Ya existe un usuario registrado con ese correo");
        } else {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            usuario.setTiempUltimoLogin(timestamp);
            usuario.setTiempoRegistro(timestamp);
            usuario = usuarioRepository.save(usuario);
            msj.setError(false);
            msj.setMensaje("Se ha creado la cuenta correctamente");
            msj.setUsuario(usuario);
        }

        return msj;
    }

}
