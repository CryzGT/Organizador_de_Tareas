
package Modelo;

/**
 *
 * @author crs12
 */
public class Usuario {
    
    int idUsuario;
    int idRol;
    String Login;
    String Nombre;
    String Correo;
    String Pass;
    boolean Activo;
    boolean interno;

    public Usuario() {
    }

    public Usuario(int idUsuario, int idRol, String Login, String Nombre, String Correo, String Pass, boolean Activo, boolean interno) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        this.Login = Login;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Pass = Pass;
        this.Activo = Activo;
        this.interno = interno;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    public boolean isInterno() {
        return interno;
    }

    public void setInterno(boolean interno) {
        this.interno = interno;
    }
    
 


 
 
 
}
