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
public class Listas {
    int idLista;
    int idTablero;
    String nombreLista;
    String descLista;

    public Listas() {
    }

    public Listas(int idLista, int idTablero, String nombreLista, String descLista) {
        this.idLista = idLista;
        this.idTablero = idTablero;
        this.nombreLista = nombreLista;
        this.descLista = descLista;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public int getIdTablero() {
        return idTablero;
    }

    public void setIdTablero(int idTablero) {
        this.idTablero = idTablero;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public String getDescLista() {
        return descLista;
    }

    public void setDescLista(String descLista) {
        this.descLista = descLista;
    }
    
}
