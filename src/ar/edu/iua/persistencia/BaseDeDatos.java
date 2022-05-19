package ar.edu.iua.persistencia;

import java.util.ArrayList;
import java.util.List;

import ar.edu.iua.modelo.academico.plan.Plan;

public class BaseDeDatos {

    private static List<Plan> planes = new ArrayList<Plan>();

    public static void add(Plan pla){
        planes.add(pla);
    }

    public static void remove(Plan pla){
        planes.add(pla);
    }
    public static Plan get(int index){
        return planes.get(index);
    }
    public static int getSize(){
        return planes.size();
    }
    
}
