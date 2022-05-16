package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.persistencia.BaseDeDatos;

public class ModificarPlanImpl implements ModificarPlan {

    @Override
    public boolean modificar(Plan plan) {
        CrearPlan crearPlan = new CrearPlanImpl();
        BorrarPlan borrarPlan = new BorrarPlanImpl();
        for (Plan planIterator : BaseDeDatos.planes) {
            if(planIterator.getAnio()==plan.getAnio()){
                if(crearPlan.crear(plan)){
                    borrarPlan.borrar(planIterator);
                    System.out.println("Plan modificado correctamete!");
                    return true;
                }else{
                    System.err.println("No se ha podido modificar el plan! Informacion Invalida");
                    return false;
                }
            }
        }

        return false;
    }
    
}
