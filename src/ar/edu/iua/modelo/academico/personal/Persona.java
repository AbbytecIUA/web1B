package ar.edu.iua.modelo.academico.personal;

import ar.edu.iua.persistencia.BaseDeDatos;

public abstract class Persona {
    public enum tipo{ESTUDIANTE, PROFESOR};
    private String documento;
    private String nombre;
    private int edad;
    private Domicilio domicilio;
    
    public Persona(){
        
    }
    public Persona(String documento, String nombre, int edad, Domicilio domicilio) {
        this.documento = documento;
        this.nombre = nombre;
        this.edad = edad;
        this.domicilio = domicilio;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Domicilio getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
    
    public static boolean comprobarExistencia(String documento, tipo t){
        boolean temp=false;
        if(t.equals(tipo.ESTUDIANTE)){
            for(int i=0;i<BaseDeDatos.getSizeEstudiantes();i++){
                if(BaseDeDatos.getEstudiante(i).getDocumento().equals(documento)){
                    temp=true;
                }
            }
        }else if (t.equals(tipo.PROFESOR)){
            for(int i=0;i<BaseDeDatos.getSizeProfesores();i++){
                if(BaseDeDatos.getProfesor(i).getDocumento().equals(documento)){
                    temp=true;
                }
            }
        }
        return temp;
    } 
    
}
