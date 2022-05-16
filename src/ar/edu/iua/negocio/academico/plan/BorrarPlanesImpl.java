package ar.edu.iua.negocio.academico.plan;

import java.util.List;

import ar.edu.iua.modelo.academico.plan.Plan;

public class BorrarPlanesImpl implements BorrarPlanes {

    public boolean borrar(List<Plan> planes) {
        BorrarPlan bPlan = new BorrarPlanImpl();
        if(planes!=null){
            for(Plan pla:planes){
                bPlan.borrar(pla);
            }
        }
        return false;
    }
    
}
