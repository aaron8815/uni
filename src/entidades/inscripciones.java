
package entidades;


public class inscripciones {
    
    private int idInscripciones;
    private Alumno alumno;
    private Materia materia;
    private double nota;

    public inscripciones() {
    }

    public inscripciones(int idInscripciones, Alumno alumno, Materia materia, double nota) {
        this.idInscripciones = idInscripciones;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public int getIdInscripciones() {
        return idInscripciones;
    }

    public void setIdInscripciones(int idInscripciones) {
        this.idInscripciones = idInscripciones;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        String inscrip= idInscripciones + " " + alumno.getApellido()+" "+ alumno.getNombre()+" "+ materia.getNombre();
     return inscrip;   
    }
    
    
}
