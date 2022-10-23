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
 * @author Sofia Paniagua
 */
public class ActividadDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int u;
    
     //Listar mis actividades
    public List listarActividades(int idListado) {
        String sql = "SELECT * FROM actividad WHERE id_listado=" + idListado;
        List<Actividad> ListTable = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Actividad act = new Actividad();
                
                act.setIdActividad(rs.getInt("id_actividad"));
                act.setIdListado(rs.getInt("id_listado"));
                act.setNombre(rs.getString("nombre"));
                act.setDescripcion(rs.getString("descripcion"));
                act.setFinalizada( rs.getBoolean("finalizada") );
                
                ListTable.add(act);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return ListTable;
    }

    //Agregar Actividad
    public int agregarActividades(Actividad actividad) {
        String sql = "insert into actividad (id_listado, nombre, "
                + "descripcion, finalizada)"
                + "values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, actividad.getIdListado());
            ps.setString(2, actividad.getNombre());
            ps.setString(3, actividad.getDescripcion());
            ps.setBoolean(4, actividad.finalizada );
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return u;
    }
    
        //Editar Actividad
    public int editarActividades(Actividad actividad) {
        String sql = "update actividad set id_listado=?, nombre=?, "
                + "descripcion=?, finalizada=? "
                + "where id_actividad = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, actividad.getIdListado());
            ps.setString(2, actividad.getNombre());
            ps.setString(3, actividad.getDescripcion());
            ps.setBoolean(4, actividad.getFinalizada() );
            ps.setInt(5, actividad.getIdActividad() );
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return u;
    }
    
     // Eliminar Actvidad
    public void eliminarActividades(int idActividad) {
        String sql = "DELETE FROM actividad WHERE id_actividad=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idActividad);
            ps.execute();
        } catch (Exception e) {

        }
    }
    
}
