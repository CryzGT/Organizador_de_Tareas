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
public class TableroDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int u;

    //Listar mis Tableros
    public List listBoard(int idUser) {
        String sql = "SELECT * FROM tablero WHERE id_propietario=" + idUser;
        List<Tablero> ListTable = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tablero tb = new Tablero();
                tb.setIdTablero(rs.getInt("id_tablero"));
                tb.setNombre(rs.getString("nombre"));
                tb.setDescripcion(rs.getString("descripcion"));
                tb.setFechaCreacion(rs.getDate("fecha_hora_creacion"));
                tb.setPublico(rs.getBoolean("publico"));
                ListTable.add(tb);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return ListTable;
    }

    //Agregar Tablero
    public int addBoard(Tablero ab) {
        String sql = "insert into tablero (id_propietario, nombre , descripcion , publico) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ab.getIdPropietario());
            ps.setString(2, ab.getNombre());
            ps.setString(3, ab.getDescripcion());
            ps.setBoolean(4, true);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return u;
    }
   //Mostra tablero por ID
     public Tablero idBoard(int id) {
        Tablero board = new Tablero();

        String sql = "SELECT * FROM tablero WHERE id_tablero=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                board.setNombre(rs.getString("nombre"));
                board.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {

        }
        return board;
    }
     
     //Modificar Tablero
      public int modifyBoard(Tablero ab) {
        String sql = "UPDATE  tablero SET nombre=?, descripcion=? WHERE id_tablero=? ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, ab.getNombre());
            ps.setString(2, ab.getDescripcion());
            ps.setInt(3, ab.getIdTablero());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return u;
    }
}
