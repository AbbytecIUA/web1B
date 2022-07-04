package ar.edu.iua.modelo.academico.personal;

public class Estudiante extends Persona{
    private float amonestaciones;

    
    public Estudiante(String documento, String nombre, int edad, Domicilio domicilio, float amonestaciones) {
        super(documento, nombre, edad, domicilio);
        this.amonestaciones = amonestaciones;
    }

    public Estudiante() {
    }

    public float getAmonestaciones() {
        return amonestaciones;
    }

    public void setAmonestaciones(float amonestaciones) {
        this.amonestaciones = amonestaciones;
    }
    
}
