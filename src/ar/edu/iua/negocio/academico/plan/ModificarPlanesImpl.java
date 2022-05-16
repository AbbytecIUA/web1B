package ar.edu.iua.negocio.academico.plan;

import java.util.List;

import ar.edu.iua.modelo.academico.plan.Plan;

public class ModificarPlanesImpl implements ModificarPlanes {

    @Override
    public boolean modificar(List<Plan> planes) {
        ModificarPlan moPlan= new ModificarPlanImpl();
        boolean status = true;
        for (Plan plan : planes) {
            if(!moPlan.modificar(plan)){
                System.err.println("No se ha podidido modificar el plan numero "+(planes.indexOf(plan)+1)+" datos incorrectos.");
                status=false;
            }
        }
        return status;
    }
    
}
