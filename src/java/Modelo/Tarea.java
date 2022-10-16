/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Sofia Paniagua
 */
public class Tarea {
    int idTarea;
    int idListado; //listado de tareas
    int idEstado;
    int idUsuarioAsignado;
    String estado;
    String nombre;
    String descripcion;
    Date fechaInicio;
    Date fechaFin;
    
    public Tarea() {
    }

    public Tarea(int idTarea, int idListado, int idEstado, int idUsuarioAsignado, String estado, String nombre, String descripcion, Date fechaInicio, Date fechaFin) {
        this.idTarea = idTarea;
        this.idListado = idListado;
        this.idEstado = idEstado;
        this.idUsuarioAsignado = idUsuarioAsignado;
        this.estado = estado;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    
    //Getters y Setters

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public int getIdListado() {
        return idListado;
    }

    public void setIdListado(int idListado) {
        this.idListado = idListado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdUsuarioAsignado() {
        return idUsuarioAsignado;
    }

    public void setIdUsuarioAsignado(int idUsuarioAsignado) {
        this.idUsuarioAsignado = idUsuarioAsignado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
}

