package ar.edu.iua.negocio.academico.plan;

import java.util.List;

import ar.edu.iua.modelo.academico.plan.Plan;

public class CrearPlanesImpl implements CrearPlanes {

    public boolean crear(List<Plan> planes) {
    boolean status=false;
    CrearPlan check= new CrearPlanImpl();
    if(planes!=null){
        status=true;
        for(Plan pl:planes){
            if(check.crear(pl)==false){
                System.err.println("Los planes no son consecutivos");
                status=false;
            }
        }
    }
    return status;
    }
    
    
}
