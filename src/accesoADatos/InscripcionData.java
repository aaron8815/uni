
package accesoADatos;

import entidades.Alumno;
import entidades.Materia;
import entidades.inscripciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<inscripciones>obtenerInscripciones(){
        String sql=" select nota, idalumno, idmateria from inscripcion where idinscripcion != 1";
        ArrayList<inscripciones>ins=new ArrayList<>();
        Alumno alu=new Alumno();
        Materia mat=new Materia();
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                inscripciones i= new inscripciones();
                
                i.setIdInscripciones(rs.getInt("idinscripciones"));
                i.setNota(rs.getDouble("nota"));
                i.setAlumno(rs.getObject("idalumno ", alu.getClass()));
                i.setMateria(rs.getObject("idmateria", mat.getClass()));
                ins.add(i);
                
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null," no se pudo ingresar a la tabla de inscripciones");
           
        }
        return ins;
        
        
    }
    
    
}
