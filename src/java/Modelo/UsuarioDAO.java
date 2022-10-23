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
    int u;

    public Usuario Validar(String User, String Pass) {
        Usuario us = new Usuario();
        String sql = "select * from usuario where login=? and contrasena=?";
        String sql2 = "select * from usuario a INNER JOIN rol b on a.id_rol = b.id_rol;";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, User);
            ps.setString(2, Pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                us.setLogin(rs.getString("login"));
                us.setPass(rs.getString("contrasena"));
                us.setNombre(rs.getString("nombre"));
                us.setIdUsuario(rs.getInt("id_usuario"));
                us.setCorreo(rs.getString("correo"));
            }

        } catch (Exception e) {
            System.out.println("ERROR USUARIO");

        }
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql2);
            rs = ps.executeQuery();
            while (rs.next()) {
                us.setRol(rs.getString("b.nombre"));
            }

        } catch (Exception e) {
            System.out.println("ERROR USUARIO");

        }
        return us;
    }

    //Agregar Tablero
    public int addUser(Usuario usuario) {
        String sql = "INSERT INTO usuario (activo, contrasena, correo, id_rol,interno,login,nombre) values(?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setString(2, usuario.getPass());
            ps.setString(3, usuario.getCorreo());
            ps.setInt(4, 1);
            ps.setBoolean(5, true);
            ps.setString(6, usuario.getLogin());
            ps.setString(7, usuario.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
        return u;
    }

}
