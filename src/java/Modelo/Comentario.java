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
public class Comentario {
    
    int idComentario;
    int idTarea;
    String usuario; 
    String detalle;
    
    public Comentario() {
    }

    public Comentario(int idComentario, int idTarea, String usuario, String detalle) {
        this.idComentario = idComentario;
        this.idTarea = idTarea;
        this.usuario = usuario;
        this.detalle = detalle;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
    
}
