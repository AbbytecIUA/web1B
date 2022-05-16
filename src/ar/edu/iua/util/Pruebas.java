package ar.edu.iua.util;

import java.util.List;

import ar.edu.iua.interfazusuario.BuscarEImprimirPlanes;
import ar.edu.iua.interfazusuario.BuscarEImprimirPlanesImpl;
import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.negocio.academico.plan.BorrarPlanes;
import ar.edu.iua.negocio.academico.plan.BorrarPlanesImpl;
import ar.edu.iua.negocio.academico.plan.BuscarPlan;
import ar.edu.iua.negocio.academico.plan.BuscarPlanImpl;
import ar.edu.iua.negocio.academico.plan.CrearPlan;
import ar.edu.iua.negocio.academico.plan.CrearPlanImpl;
import ar.edu.iua.negocio.academico.plan.CrearPlanes;
import ar.edu.iua.negocio.academico.plan.CrearPlanesImpl;
import ar.edu.iua.negocio.academico.plan.ModificarPlan;
import ar.edu.iua.negocio.academico.plan.ModificarPlanImpl;
import ar.edu.iua.negocio.academico.plan.ModificarPlanes;
import ar.edu.iua.negocio.academico.plan.ModificarPlanesImpl;
import ar.edu.iua.persistencia.BaseDeDatos;

public class Pruebas {

    public void probar() {

        List<Plan> planes = GenerarEjemplosDePlanes.generar(10, true);        

        System.out.println("\n\nSe crearon " + planes.size() + " planes.");


        
        CrearPlanes crearPlanes = new CrearPlanesImpl();
        crearPlanes.crear(planes);

        BuscarEImprimirPlanes buscarEImprimirPlanes = new BuscarEImprimirPlanesImpl();
        buscarEImprimirPlanes.buscar("20"); 
        System.out.println("-------------------------------------------------");

        BorrarPlanes borrarPlanes = new BorrarPlanesImpl();
        borrarPlanes.borrar(planes);// RECORDA QUE SOLO BORRA PLANES EN BORRADOR 

        buscarEImprimirPlanes.buscar("20"); 
        System.out.println("-------------------------------------------------");

        CrearPlan crearPlan = new CrearPlanImpl();
        for(Plan pla:planes){
            boolean ok = crearPlan.crear(pla);
            if (ok == false) {
                System.err.println("Informacion de plan "+planes.indexOf(pla)+" incorrecta");
                return;
            }
        }
      

        

        
        ModificarPlan modificarPlan = new ModificarPlanImpl();
        
        planes.get(0).setAnio(2050);
        planes.get(1).setAnio(2003);

        boolean ok = modificarPlan.modificar(planes.get(0));
        System.out.println("Se modifico el plan " + planes.get(0) + " ? = " + (ok ? "SI" : "NO") );

        ok = modificarPlan.modificar(planes.get(1));
        System.out.println("Se modifico el plan " + planes.get(1) + " ? = " + (ok ? "SI" : "NO") ); 
        // NOTA: esto tiene sentido ya que los planes se identifican mediante el año y el plan 2003 no existe como para usarlo de referencia a la hora de modificarlo.
        List<Plan> planes1y2 = planes.subList(0, 2);
        ModificarPlanes modificarPlanes = new ModificarPlanesImpl();
        ok=modificarPlanes.modificar(planes1y2);
        System.out.println("Se modificaron los planes? = " + (ok ? "SI" : "NO") ); 


        // debe buscar todos los planes que contengan en sus datos (incluido años y materias)
        // devolver todos los planes q contengan un valor 18, o mate o hist o 5
        buscarEImprimirPlanes.buscar(" 18 mate hist 5"); 

        BuscarPlan buscarPlan = new BuscarPlanImpl();
        Plan planabuscar = buscarPlan.buscar(2018);
        System.out.println(BaseDeDatos.planes.get(0)==planabuscar?"Se encontro el plan 2018":"No se encontro el plan 2018");
        
        




    }

}
