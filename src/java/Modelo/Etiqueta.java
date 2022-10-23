/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Anderson
 */
public class Etiqueta {
    
    int idEtiqueta;
    String nombreEtiqueta;
    Boolean activa;
    int idTablero;

    public Etiqueta() {
    }

    public Etiqueta(int idEtiqueta, String nombreEtiqueta, Boolean activa, int idTablero) {
        this.idEtiqueta = idEtiqueta;
        this.nombreEtiqueta = nombreEtiqueta;
        this.activa = activa;
        this.idTablero = idTablero;
    }

    public int getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(int idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public String getNombreEtiqueta() {
        return nombreEtiqueta;
    }

    public void setNombreEtiqueta(String nombreEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public int getIdTablero() {
        return idTablero;
    }

    public void setIdTablero(int idTablero) {
        this.idTablero = idTablero;
    }
    
    
    
}
