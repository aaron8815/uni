
package universidadejemplo;

import accesoADatos.AlumnoData;
import accesoADatos.InscripcionData;
import accesoADatos.MateriaData;
import entidades.Alumno;
import entidades.Materia;
import entidades.inscripciones;
import java.time.LocalDate;
import java.time.Month;



public class UniversidadEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
       // Alumno alumno= new Alumno(2134131, "juan", "palacios", LocalDate.of(2000, Month.MARCH, 20), true);
        AlumnoData aluda = new AlumnoData();
        //aluda.guardarAlumno(alumno);
        Alumno alencon= aluda.buscarAlumnno(4);
        System.out.println("dni: "+ alencon.getDNI());
        System.out.println("apellido "+ alencon.getApellido());
        System.out.println("nombre "+ alencon.getNombre());
        */
       
       //AlumnoData alu= new AlumnoData();
       /*Alumno hector=alu.buscarAlumnoPorDNI(2134131);
       
        System.out.println("apellido: "+ hector.getApellido());
        System.out.println("nombre: "+hector.getNombre());
        System.out.println("dni : "+ hector.getDNI());
        System.out.println("idAlumno : "+ hector.getIdAlumno());
        System.out.println("fechaNacimiento : "+ hector.getFechaNacimiento());
      */
      /* for(Alumno alumnos:alu.listarAlumno()){
           
           System.out.println(alumnos.getDNI());
           System.out.println(alumnos.getApellido());
           System.out.println(alumnos.getNombre());
           System.out.println(alumnos.getFechaNacimiento());
        */
        //alu.eliminarAlumno(1);
        //MateriaData mat= new MateriaData();
       // mat.eliminarMateria(4);
       /* Materia proyecto= new Materia("proyecto final", 9, true);
        mat.modificarMateria(proyecto);
        */
       /* materia = mat.buscarMateria(3);
        System.out.println(materia.getNombre());
        System.out.println(materia.getAnioMateria());
        System.out.println(materia.isEstado());

        */
       /*for(Materia materia: mat.listarMateria()){
           System.out.println("idmateria "+materia.getIdmateria());
           System.out.println("nombre "+materia.getNombre());
           System.out.println("año "+materia.getAnioMateria());
         */
       Alumno alu = new Alumno(5,33565456, "joel ", "mena", LocalDate.of(1999, Month.MARCH, 20), true);
       AlumnoData aluda = new AlumnoData();
       aluda.guardarAlumno(alu);
       Materia sociales= new Materia(1, "sociales", 8, true);
       MateriaData mat=new MateriaData();
       mat.guardarMateria(sociales);
       inscripciones nueva= new inscripciones(1, alu, sociales, 8.7);
       InscripcionData ins= new InscripcionData();
       ins.guardarInscripcion(nueva);
       
       
       }
    

      
       }
    
    
    
    
    
    
    
}
