package ar.edu.iua.interfazusuario;

import java.util.List;

import ar.edu.iua.modelo.academico.plan.AnioPlan;
import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.negocio.academico.plan.BuscarPlanesImpl;

public class BuscarEImprimirPlanesImpl implements BuscarEImprimirPlanes {
    // este metodo debe imprimir un listado de planes segun los terminos de busqueda
    // se valora que la impresion sea tabulada, con columnas o en forma de tarjetas
    
    // ej columnas
        //          PLAN        Años        Materias        ESTADO
        //          ----        ----        --------       -------- 
        //          2018          5            42          ACTIVO  
        //          2013          7            2           BORRADOR  

    // ej tarjetas
        //      -------------------------------------
        //      |  Plan de estudios 2108 (ACTIVO)   |         
        //      -------------------------------------
        //      -------------------------------------
        //      |  Plan de estudios 2013 (BORRADOR) |         
        //      -------------------------------------
    public void buscar(String terminos) {
        
        BuscarPlanesImpl bpi = new BuscarPlanesImpl();
        List<Plan> lista = bpi.buscar(terminos);
        System.out.println("Plan\t\t Años\t\t Materias\t\t Estado");
        System.out.println("-------------------------------------------------");
        int suma;
        for (Plan plan : lista) {
            suma=0;
            for (AnioPlan an : plan.getAnios()) {
                suma=suma+an.getMaterias().size();
            }
            System.out.printf("%s\t\t %d\t\t %d\t\t %s\n",plan.getAnio(),plan.getAnios().size(),suma,plan.isEstadoActivo()?"Activo":plan.isEstadoBorrador()?"Borrador":plan.isEstadoNoActivo()?"No Activo":"Desconocido");
            
        }
    }
    
}
