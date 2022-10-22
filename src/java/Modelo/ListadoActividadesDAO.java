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
public class ListadoActividadesDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int u;
    
     //Listar mis Tableros
    public List listarListadosActividades(int idTarea) {
        String sql = "SELECT * FROM listado_actividades WHERE id_tarea=" + idTarea;
        List<ListadoActividades> ListTable = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ListadoActividades la = new ListadoActividades();
                
                la.setIdListado(rs.getInt("id_listado"));
                la.setIdTarea(rs.getInt("id_tarea"));
                la.setNombre(rs.getString("nombre"));
                la.setDescripcion(rs.getString("descripcion"));
                la.setFechaHoraCreacion( null /*rs.getDate("fecha_hora_creacion")*/ );
                la.setPorcentajeAvance(rs.getInt("porcentaje_avance"));
                ListTable.add(la);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return ListTable;
    }

    //Agregar Tablero
    public int agregarListadoActividades(ListadoActividades la) {
        String sql = "insert into listado_actividades (id_tarea, nombre, "
                + "descripcion, fecha_hora_creacion, porcentaje_avance)"
                + "values(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, la.getIdTarea());
            ps.setString(2, la.getNombre());
            ps.setString(3, la.getDescripcion());
            ps.setDate(4, null);
            ps.setInt(5, la.getPorcentajeAvance());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return u;
    }
    
    
     // Eliminar Tarea
    public void eliminarListadoActividades(int idListado) {
        String sql = "DELETE FROM listado_actividades WHERE id_listado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idListado);
            ps.execute();
        } catch (Exception e) {

        }
    }
    
}
