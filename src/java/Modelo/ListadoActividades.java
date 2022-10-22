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
public class ListadoActividades {
    
    int idListado;
    int idTarea;
    String nombre;
    String descripcion;
    Date fechaHoraCreacion;
    int porcentajeAvance;

    public ListadoActividades() {
    }

    public ListadoActividades(int idListado, int idTarea, String nombre, String descripcion, Date fechaHoraCreacion, int porcentajeAvance) {
        this.idListado = idListado;
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.porcentajeAvance = porcentajeAvance;
    }
    
    //Getters y Setters

    public int getIdListado() {
        return idListado;
    }

    public void setIdListado(int idListado) {
        this.idListado = idListado;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
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

    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public int getPorcentajeAvance() {
        return porcentajeAvance;
    }

    public void setPorcentajeAvance(int porcentajeAvance) {
        this.porcentajeAvance = porcentajeAvance;
    }
    
    
}
