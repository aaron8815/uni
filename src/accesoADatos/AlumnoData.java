
package accesoADatos;

import entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;


public class AlumnoData {
    private Connection con=null;

    public AlumnoData() {
        con= conexion.getConnection();
        
        
    }
    
    public void guardarAlumno(Alumno alumno){
        String sql="insert into alumno(dni,apellido,nombre,fechaNacimiento,estado)values (?,?,?,?,?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,alumno.getDNI());
            ps.setString(2,alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4,Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"alumno agregado");
                
                
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error al entrar a la tabla alumno");
            
        }
        
    }
    
    public Alumno buscarAlumnno(int id){
        String sql= "select dni, apellido, nombre, fechaNacimiento"
                + " from alumno where idAlumno=? and estado=1";
        Alumno alumno=null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                
                alumno= new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDNI(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                
                
            }else {
                JOptionPane.showMessageDialog(null,"no existe el alumno con ese id");
                
            
            }
            ps.close();
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error al entrar a la tabla alumno");
        }
        
        
        return alumno;
    }
     public Alumno buscarAlumnoPorDNI(int dni){
         
         String sql= "select idAlumno, apellido, nombre, dni , fechaNacimiento from alumno "
                 + "where dni=?";
         Alumno alumno=null;
         
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                alumno= new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setDNI(rs.getInt("dni"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                
                
            }else{
                JOptionPane.showMessageDialog(null,"no existe el alumno con el dni ingresado"+dni);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error al entrar a la tabla alumno");
        }
        return alumno;
         
     }
    public List<Alumno> listarAlumno(){
        
        String sql= "select idAlumno , apellido, nombre,dni, fechaNacimiento from alumno where estado = 1";
        ArrayList<Alumno>alumnos= new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Alumno alumno= new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setDNI(rs.getInt("dni"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                
                alumnos.add(alumno);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error al entrar a la tabla alumno"+ex.getMessage());
        }
        
        return alumnos;
    }
    
    public void modificarAlumno(int idAlumno, int dni, String apellido,String nombre){
        
        String sql= "update alumno set dni = ? , apellido=?, nombre = ? where idAlumno=2";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, dni);
            ps.setString(3, apellido);
            ps.setString(4, nombre);
            int fila=ps.executeUpdate();
            if(fila>0){
                JOptionPane.showMessageDialog(null, "alumno modificado");
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se pudo ingresar a la tabla de alumno");
        }
        
        
    }
    public void eliminarAlumno(int id){
        
        String sql= " delete from alumno where idAlumno = ?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            int alu = ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"alumno eliminado..." + alu);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se pudo ingresar a la tabla de alumno");
        }
        
    }
    
}
