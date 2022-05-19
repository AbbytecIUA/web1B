package ar.edu.iua.negocio.academico.plan;

import java.util.List;

import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.modelo.exceptions.BorrarPlanEx;

public class BorrarPlanesImpl implements BorrarPlanes {

    public boolean borrar(List<Plan> planes) throws BorrarPlanEx {
        BorrarPlan bPlan = new BorrarPlanImpl();
        if(planes!=null){
            for(Plan pla:planes){
                bPlan.borrar(pla);
            }
        }
        return false;
    }
    
}
