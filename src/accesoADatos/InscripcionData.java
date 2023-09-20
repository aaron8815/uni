
package accesoADatos;

import entidades.inscripciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class InscripcionData {
    private Connection con = null;
    private MateriaData matdata;
    private AlumnoData aluData;

    public InscripcionData() {
        con = conexion.getConnection();
        
    }
    
    public void guardarInscripcion(inscripciones i){
        
        String sql= " insert into inscripcion (nota, idAlumno, idmateria) "
                + "value(?,?,?)";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setDouble(1, i.getNota());
            ps.setInt(2, i.getAlumno().getIdAlumno());
            ps.setInt(3,i.getMateria().getIdmateria());
            int nueva=ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "inscripcion registrada");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"no se pudo ingresar a la tabla de inscripciones");
           
        }
        
        
    }
    
    
    
    
}
