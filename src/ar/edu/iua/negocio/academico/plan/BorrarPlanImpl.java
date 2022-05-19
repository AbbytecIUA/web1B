package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.modelo.exceptions.BorrarPlanEx;
import ar.edu.iua.persistencia.BaseDeDatos;

public class BorrarPlanImpl implements BorrarPlan {

    public boolean borrar(Plan plan) throws BorrarPlanEx {
        if(plan!=null){
            if(plan.isEstadoBorrador()){
                BaseDeDatos.remove(plan);
            }
        }else{
            throw new BorrarPlanEx("El plan es nulo");
        }
        return true;
    }
}
