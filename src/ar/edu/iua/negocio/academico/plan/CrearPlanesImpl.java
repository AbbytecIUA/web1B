package ar.edu.iua.negocio.academico.plan;

import java.util.List;

import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.modelo.exceptions.CrearPlanEx;

public class CrearPlanesImpl implements CrearPlanes {

    public boolean crear(List<Plan> planes) throws CrearPlanEx {
        CrearPlan check = new CrearPlanImpl();
        if (planes != null) {
            for (Plan pl : planes) {
                try {
                    check.crear(pl);
                } catch (CrearPlanEx e) {
                   throw new CrearPlanEx("Los planes no son consecutivos");
                }
        }
    }else{

    }
    return true;
    }
    
    
}
