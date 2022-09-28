/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class ListasDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int u;

    //Listar mis Tableros
    public List listLists(int idBoard) {
        String sql = "SELECT * FROM listado_tareas WHERE  id_tablero=" + idBoard;
        List<Listas> listLists = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Listas al = new Listas();
                al.setIdLista(rs.getInt("id_listado"));
                al.setNombreLista(rs.getString("nombre"));
                al.setDescLista(rs.getString("descripcion"));
                listLists.add(al);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return listLists;
    }
    //Agregar Tablero
    public int addList(Listas lt) {
        String sql = "insert into listado_tareas (id_tablero, nombre , descripcion) values(?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, lt.getIdTablero());
            ps.setString(2, lt.getNombreLista());
            ps.setString(3, lt.getDescLista());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return u;
    }
}
