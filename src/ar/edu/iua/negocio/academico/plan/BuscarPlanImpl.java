package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.persistencia.BaseDeDatos;

public class BuscarPlanImpl implements BuscarPlan {

    @Override
    public Plan buscar(int anio) {
        for (int i=0; i<BaseDeDatos.getSizePlanes();i++) {
            if(BaseDeDatos.getPlan(i).getAnio()==anio){
                return BaseDeDatos.getPlan(i);
            }
        }
        return null;
    }
    
}
