package com.Prueba.BackEnd.utils;

import java.util.ArrayList;

import com.Prueba.BackEnd.models.PaisModel;
import com.Prueba.BackEnd.models.UsuarioModel;

public class Mensaje {

    private String mensaje;
    private boolean error;
    private ArrayList<UsuarioModel> listaUsarios;
    private UsuarioModel usuario;
    private ArrayList<PaisModel> listaPaises;

    public Mensaje() {
    }

    public ArrayList<PaisModel> getListaPaises() {
        return listaPaises;
    }

    public void setListaPaises(ArrayList<PaisModel> listaPaises) {
        this.listaPaises = listaPaises;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public ArrayList<UsuarioModel> getListaUsarios() {
        return listaUsarios;
    }

    public void setListaUsarios(ArrayList<UsuarioModel> listaUsarios) {
        this.listaUsarios = listaUsarios;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
