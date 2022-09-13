
package config;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author crs12
 */
public class Conexion {
    
    Connection con;
    String url="jdbc:mysql://localhost:3306/organizador_tareas";
    String user="root";
    String pass="";
    
    
    public Connection Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception u){
                }
    
    return con;
    }
    
    
}
