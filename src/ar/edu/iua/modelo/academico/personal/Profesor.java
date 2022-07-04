package ar.edu.iua.modelo.academico.personal;

public class Profesor extends Persona{
    private String[] titulos;

    
    public Profesor(String documento, String nombre, int edad, Domicilio domicilio, String[] titulos) {
        super(documento, nombre, edad, domicilio);
        this.titulos = titulos;
    }

    public Profesor() {
    }

    public String[] getTitulos() {
        return titulos;
    }

    public void setTitulos(String[] titulos) {
        this.titulos = titulos;
    }
    
}
