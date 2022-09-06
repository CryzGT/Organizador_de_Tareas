
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class UsuarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
  
    
    public Usuario Validar (String User, String Pass ) {
        Usuario  us=new Usuario();
        String sql = "select * from usuario where User=? and Pass=?";
        
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, User);
            ps.setString(2, Pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                us.setIdUsuario(rs.getInt("IdUsuario"));
                us.setUser(rs.getString("User"));
                us.setPass(rs.getString("Pass"));
                us.setNombres(rs.getString("Nombres"));
            }
            
        }catch (Exception e){
            System.out.println("ERROR USUARIO");
        
        }
        return us;
       

}
    

}
