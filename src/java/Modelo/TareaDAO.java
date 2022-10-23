/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sofia Paniagua
 */
public class TareaDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int u;
    
     //Listar mis tareas
    public List listarTareas(int idListado) {
        String sql = "SELECT * FROM tarea WHERE id_listado=" + idListado;
        List<Tarea> ListTable = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarea tarea = new Tarea();
                tarea.setIdTarea(rs.getInt("id_tarea"));
                tarea.setIdListado(rs.getInt("id_listado"));
                tarea.setIdEstado(rs.getInt("id_estado"));
                tarea.setEstado(rs.getString("estado"));
                tarea.setIdUsuarioAsignado(rs.getInt("id_usuario_asignado"));
                tarea.setNombre(rs.getString("nombre"));
                tarea.setDescripcion(rs.getString("descripcion"));
                tarea.setFechaInicio(rs.getDate("fecha_inicio"));
                tarea.setFechaFin(rs.getDate("fecha_fin"));
                ListTable.add(tarea);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return ListTable;
    }

    //Agregar tarea
    public int agregarTarea(Tarea tarea) {
        String sql = "insert into tarea (id_listado, id_estado, id_usuario_asignado,"
                + "nombre, descripcion, fecha_inicio, fecha_fin, estado) "
                + "values(?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, tarea.getIdListado());
            ps.setInt(2, tarea.getIdEstado());
            ps.setInt(3, tarea.getIdUsuarioAsignado());
            ps.setString(4, tarea.getNombre());
            ps.setString(5, tarea.getDescripcion());
            ps.setDate(6, (Date) tarea.getFechaInicio());
            ps.setDate(7, (Date) tarea.getFechaFin());
            ps.setString(8, "Iniciada");
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return u;
    }
    
        //Agregar Tablero
    public int editarTarea(Tarea tarea) {
       
        String sql = "update tarea set id_listado = ?, id_usuario_asignado = ?, fecha_inicio = ?, fecha_fin = ?, "
                + "nombre = ?, descripcion = ? where id_tarea = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, tarea.getIdListado());
            ps.setInt(2, tarea.getIdUsuarioAsignado());
            ps.setDate(3, (Date) tarea.getFechaInicio());
            ps.setDate(4, (Date) tarea.getFechaFin());
            ps.setString(5, tarea.getNombre());
            ps.setString(6, tarea.getDescripcion());
            ps.setInt(7, tarea.getIdTarea());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return u;
    }
    
    
     // Eliminar Tarea
    public void eliminarTarea(int idTarea) {
        String sql = "DELETE FROM tarea WHERE id_tarea=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idTarea);
            ps.execute();
        } catch (Exception e) {

        }
    }
    
    public int agregarComentario(int idTarea, String comentario){
        String sql = "insert into comentario (id_tarea, usuario, detalle)"
                + "values(?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, idTarea);
            ps.setInt(2, 1);
            ps.setString(3, comentario);
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return u;
    }
    
        public List listarComentarios(int idTarea) {
        String sql = "SELECT * FROM comentario WHERE id_tarea=" + idTarea;
        List<Comentario> ListTable = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Comentario comentario = new Comentario();
                comentario.setIdComentario(rs.getInt("id_comentario"));
                comentario.setUsuario(rs.getString("usuario"));
                comentario.setDetalle(rs.getString("detalle"));
                comentario.setIdTarea(rs.getInt("id_tarea"));
                ListTable.add(comentario);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return ListTable;
    }
}
