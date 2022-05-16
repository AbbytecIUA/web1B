package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.persistencia.BaseDeDatos;

public class BuscarPlanImpl implements BuscarPlan {

    @Override
    public Plan buscar(int anio) {
        for (Plan plan : BaseDeDatos.planes) {
            if(plan.getAnio()==anio){
                return plan;
            }
        }
        return null;
    }
    
}
