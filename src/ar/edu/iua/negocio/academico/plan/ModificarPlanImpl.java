package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.modelo.exceptions.BorrarPlanEx;
import ar.edu.iua.modelo.exceptions.CrearPlanEx;
import ar.edu.iua.modelo.exceptions.ModificarPlanEx;
import ar.edu.iua.persistencia.BaseDeDatos;

public class ModificarPlanImpl implements ModificarPlan {

    @Override
    public boolean modificar(Plan plan) throws ModificarPlanEx, BorrarPlanEx {
        CrearPlan crearPlan = new CrearPlanImpl();
        BorrarPlan borrarPlan = new BorrarPlanImpl();
        for (int i=0; i<BaseDeDatos.getSize();i++) {
            if (BaseDeDatos.get(i).getAnio() == plan.getAnio()) {
                try {
                    if (crearPlan.crear(plan)) {
                        borrarPlan.borrar(BaseDeDatos.get(i));
                        System.out.println("Plan modificado correctamete!");
                        return true;
                    } else {
                        System.err.println("No se ha podido modificar el plan! Informacion Invalida");
                        return false;
                    }
                } catch (CrearPlanEx e) {
                    throw new ModificarPlanEx(e.getMessage());
                }
            }
        }

        return false;
    }
    
}
