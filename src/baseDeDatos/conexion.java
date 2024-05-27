
package baseDeDatos;

/**
 *
 * @author JUNIOR SILVA
 */

import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.SQLDataException; 
import java.sql.SQLException;

public class conexion {

    private static Connection conn;
    private static final String drive = "com.mysql.jdbc.Driver" ;
   
   
    public conexion(){
        conn = null;
        try{
            
         Class.forName(drive);
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/visi","root","");               
          
         if(conn!=null){
             System.out.println("Estoy conectado a la base de datos");
         }
         
         
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error en la conexion: "+e);
            
        }
        
    }
    
    public Connection getConnection(){
        
        return conn;
    }
    
    public void desconectar(){
        
        conn = null;
        if(conn == null){
            System.out.println("Conexion terminada");
            
            
        }
        
    }
    


    
    
    
    
    
}
