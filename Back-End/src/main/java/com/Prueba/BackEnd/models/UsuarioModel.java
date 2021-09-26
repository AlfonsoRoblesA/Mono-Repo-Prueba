package com.Prueba.BackEnd.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String nombre;
    private String correo;
    private String contrasena;
    private Timestamp tiempoRegistro;
    private Timestamp tiempUltimoLogin;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public Timestamp getTiempUltimoLogin() {
        return tiempUltimoLogin;
    }

    public void setTiempUltimoLogin(Timestamp tiempUltimoLogin) {
        this.tiempUltimoLogin = tiempUltimoLogin;
    }

    public Timestamp getTiempoRegistro() {
        return tiempoRegistro;
    }

    public void setTiempoRegistro(Timestamp tiempoRegistro) {
        this.tiempoRegistro = tiempoRegistro;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
