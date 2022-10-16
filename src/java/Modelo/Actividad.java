/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Sofia Paniagua
 */
public class Actividad {
    
    int idActividad;
    int idListado; //listado de actividades
    String nombre;
    String descripcion;
    Boolean finalizada;

    public Actividad() {
    }

    public Actividad(int idActividad, int idListado, String nombre, String descripcion, Boolean finalizada) {
        this.idActividad = idActividad;
        this.idListado = idListado;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.finalizada = finalizada;
    }
    
    //Getters y Setteres

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getIdListado() {
        return idListado;
    }

    public void setIdListado(int idListado) {
        this.idListado = idListado;
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

    public Boolean getFinalizada() {
        return finalizada;
    }

    public void setFinalizada(Boolean finalizada) {
        this.finalizada = finalizada;
    }
    
    
}
