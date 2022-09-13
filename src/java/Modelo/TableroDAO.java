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
    


    
     //Listar mis Tableros
    public List listarTableros(){
        String sql = "SELECT * FROM tablero;";
        List<Tablero> ListTable = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); 
            while(rs.next()){
                Tablero tb = new Tablero();
                tb.setIdTablero(rs.getInt("id_tablero"));
                tb.setNombre(rs.getString("nombre"));
                tb.setDescripcion(rs.getString("descripcion"));
                tb.setFechaCreacion(rs.getDate("fecha_hora_creacion"));
                tb.setPublico(rs.getBoolean("publico"));
                ListTable.add(tb);
            } 
        }catch(Exception e){
            System.out.println("Error" + e);
        }
        return ListTable;
    }
}
