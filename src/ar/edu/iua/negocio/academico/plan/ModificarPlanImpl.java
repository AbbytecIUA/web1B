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
        for (int i=0; i<BaseDeDatos.getSizePlanes();i++) {
            System.out.println(BaseDeDatos.getPlan(i).getAnio() + " " + plan.getAnio());
            if (BaseDeDatos.getPlan(i).getAnio().equals(plan.getAnio())) {
                System.out.println("NO HAY CHANCE");
                try {
                    Plan old = (Plan) BaseDeDatos.getPlan(i).clone();
                    borrarPlan.borrarActivo(BaseDeDatos.getPlan(i));
                    if (crearPlan.crear(plan)) {
                        System.out.println("Plan modificado correctamete!");
                        return true;
                    } else {
                        crearPlan.crear(old);
                        System.err.println("No se ha podido modificar el plan! Informacion Invalida");
                        return false;
                    }
                } catch (CloneNotSupportedException | CrearPlanEx e1) {
                    throw new ModificarPlanEx(e1.getMessage());
                }
            }
        }

        return false;
    }
    
}
