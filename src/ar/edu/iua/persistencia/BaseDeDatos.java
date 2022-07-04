package ar.edu.iua.persistencia;

import java.util.ArrayList;
import java.util.List;

import ar.edu.iua.modelo.academico.personal.Estudiante;
import ar.edu.iua.modelo.academico.personal.Profesor;
import ar.edu.iua.modelo.academico.plan.Plan;

public class BaseDeDatos {

    private static List<Plan> planes = new ArrayList<Plan>();
    private static List<Estudiante> estudiantes = new ArrayList<Estudiante>();
    private static List<Profesor> profesores = new ArrayList<Profesor>();

    public static void addPlan(Plan pla){
        planes.add(pla);
    }

    public static void removePlan(Plan pla){
        planes.remove(pla);
    }
    public static Plan getPlan(int index){
        return planes.get(index);
    }
    public static int getSizePlanes(){
        return planes.size();
    }

    public static void addEstudiante(Estudiante est){
        estudiantes.add(est);
    }

    public static void removeEstudiante(String dni){
        Estudiante aBorrar= new Estudiante();
        for (Estudiante estudiante : estudiantes) {
            if(estudiante.getDocumento().equals(dni)){
                aBorrar = estudiante;
            }
        }
        estudiantes.remove(aBorrar);
    }
    public static Estudiante getEstudiante(int index){
        return estudiantes.get(index);
    }
    public static int getSizeEstudiantes(){
        return estudiantes.size();
    }

    public static void addProfesor(Profesor pro){
        profesores.add(pro);
    }

    public static void removeProfesor(String dni){
        Profesor aBorrar= new Profesor();
        for (Profesor profe : profesores) {
            if(profe.getDocumento().equals(dni)){
                aBorrar = profe;
            }
        }
        profesores.remove(aBorrar);
    }
    public static Profesor getProfesor(int index){
        return profesores.get(index);
    }
    public static int getSizeProfesores(){
        return profesores.size();
    }
    
}
