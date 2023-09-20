
package accesoADatos;

import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MateriaData {
    private Connection con =null;

    public MateriaData() {
        con= conexion.getConnection();
        
        
    }
    public void guardarMateria(Materia materia){
        
        String sql="insert into materia (nombre, año, estado) "
                + "values(?,?,?)";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,materia.getNombre());
            ps.setInt(2,materia.getAnioMateria());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                materia.setIdmateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"materia agregada");
            }
            ps.close();
                    
                    
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error al ingresar a la tabla de materias");
        }
        
        
    }
    
     public Materia buscarMateria(int id){
         String sql="select nombre, año, estado from materia where idmateria = ?";
         Materia materia=null;
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                materia = new Materia();
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));
                
            }else {
                JOptionPane.showMessageDialog(null,"no se encontro la materia");
            }
            rs.close();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"no se pudo ingresar a tabla materia");
           
        }
         
         return materia;
     }
     
     public void modificarMateria(Materia materia){
         
         String sql="update materia set  nombre=?, año=?, estado=? where idmateria =2";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isEstado());
            int fila=ps.executeUpdate();
            if(fila>0){
            JOptionPane.showMessageDialog(null,"materia modificada");
            }
        } catch (SQLException ex) {
           
        }
        
     }
     
     public void eliminarMateria(int id){
         String sql=" delete FROM materia WHERE idMateria = ?";
         
        try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           int fila = ps.executeUpdate();
           JOptionPane.showMessageDialog(null,"materia eliminada " + fila);
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"no se pudo ingresar a la tabla de materias");
           
        }
         
     }
     
     public List<Materia> listarMateria(){
         String sql= " select idmateria, nombre, año from materia where estado = 1";
         ArrayList<Materia>materias = new ArrayList();
         
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Materia materia = new Materia();
                materia.setIdmateria(rs.getInt("idmateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                
                materias.add(materia);
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"no se pudo ingresar a la tabla de materias");
        }
         
         
         return materias;
     }
    
    
    
    
}
;