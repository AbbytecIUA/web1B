package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.persistencia.BaseDeDatos;

public class BorrarPlanImpl implements BorrarPlan {

    public boolean borrar(Plan plan) {
        if(plan!=null){
            if(plan.isEstadoBorrador()){
                BaseDeDatos.planes.remove(plan);
                return true;
            }
        }
        return false;
    }
}
