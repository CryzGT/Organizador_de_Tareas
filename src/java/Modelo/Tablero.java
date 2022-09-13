/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Anderson
 */
public class Tablero {
    int idTablero;
    int idPropietario;
    String nombre;
    String descripcion;
    boolean publico;
    Date fechaCreacion;

    public Tablero() {
    }

    public Tablero(int idTablero, int idPropietario, String nombre, String descripcion, boolean publico, Date fechaCreacion) {
        this.idTablero = idTablero;
        this.idPropietario = idPropietario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.publico = publico;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdTablero() {
        return idTablero;
    }

    public void setIdTablero(int idTablero) {
        this.idTablero = idTablero;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
}

