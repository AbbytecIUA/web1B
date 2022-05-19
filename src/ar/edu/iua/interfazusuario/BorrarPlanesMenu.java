package ar.edu.iua.interfazusuario;

import ar.edu.iua.Main;
import ar.edu.iua.negocio.academico.plan.BuscarPlan;
import ar.edu.iua.negocio.academico.plan.BuscarPlanImpl;
import ar.edu.iua.persistencia.BaseDeDatos;

public class BorrarPlanesMenu {
    public BorrarPlanesMenu(){
        System.out.println("Ingrese el/los numero/s de cada año a borrar. Para finalizar, ingrese 0:");
        int valor = Main.scanner.nextInt();
        while(valor!=0){
            BuscarPlan buscarPlan = new BuscarPlanImpl();
            if(valor!=0){
                BaseDeDatos.remove(buscarPlan.buscar(valor));
            }
            valor = Main.scanner.nextInt();
        }
    }
}
