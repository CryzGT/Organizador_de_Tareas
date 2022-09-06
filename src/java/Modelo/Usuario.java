
package Modelo;

/**
 *
 * @author crs12
 */
public class Usuario {
    
    int idUsuario;
    String Nombres;
    String Telefono;
    String Estado;
    String User;
    String Pass;
    
 public Usuario(){
 }   

    public Usuario(int idUsuario, String Nombres, String Telefono, String Estado, String User, String Pass) {
        this.idUsuario = idUsuario;
        this.Nombres = Nombres;
        this.Telefono = Telefono;
        this.Estado = Estado;
        this.User = User;
        this.Pass = Pass;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }


 
 
 
}
