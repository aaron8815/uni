
package accesoADatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class conexion {
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB= "universidaddellapunta";
    private static final String USUARIO="root";
    private static final String PASWORD="";
    private static Connection connection;
    
    private conexion(){
        
    }

   
    
    public static Connection getConnection(){
        
        if(connection== null){
            
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection= DriverManager.getConnection(URL+DB,USUARIO, PASWORD);
                JOptionPane.showMessageDialog(null," conectado....");
                
            
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"erro al cargar los driver"+ex.getMessage());
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"error al conectarse a la base de datos");
                
            }
            
        }return connection;
    }
    
}
