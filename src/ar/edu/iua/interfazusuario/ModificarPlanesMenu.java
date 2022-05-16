package ar.edu.iua.interfazusuario;

import java.util.ArrayList;
import java.util.List;

import ar.edu.iua.Main;
import ar.edu.iua.modelo.academico.plan.AnioPlan;
import ar.edu.iua.modelo.academico.plan.AnioPlanImpl;
import ar.edu.iua.modelo.academico.plan.MateriaImpl;
import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.negocio.academico.plan.BuscarPlan;
import ar.edu.iua.negocio.academico.plan.BuscarPlanImpl;

public class ModificarPlanesMenu {
    public ModificarPlanesMenu() {
        String temp=new String();
        double tempb=0;
        
        System.out.println("Ingrese el/los numero/s de cada año a modificar, para confirmar, ingrese 0:");
        int valor = Main.scanner.nextInt();
        List<Plan> planesModificados = new ArrayList<>();
        while (valor != 0) {
            BuscarPlan buscarPlan = new BuscarPlanImpl();
            planesModificados.add(buscarPlan.buscar(valor));
            valor = Main.scanner.nextInt();
        }
        for (Plan plan : planesModificados) {
            System.out.println("Para cualquier valor que no desee modificar, simplemente presione enter...");
            System.out.println("Ingrese el estado del plan(1- Borrador, 2- Activo, 3- No Activo)");
            System.out.println("Estado actual: "
                    + (plan.isEstadoActivo() ? "Activo" : plan.isEstadoNoActivo() ? "No Activo" : "Borrador"));
            switch (Main.scanner.nextInt()) {
                case 1:
                    plan.setEstadoBorrador();
                    break;
                case 2:
                    plan.setEstadoActivo();
                    break;
                case 3:
                    plan.setEstadoNoActivo();
                    break;
                default:
                    break;
            }

            System.out.println("Ingrese la cantidad de años en el plan, cantidad actual=" + plan.getAnios().size() + ":");
            int cant = Main.scanner.nextInt();
            if (cant < plan.getAnios().size()) {
                for (int j = plan.getAnios().size(); j > cant; j--) {
                    plan.getAnios().remove(j);
                }
            } else{
                for (int j = 0; j < (cant + 1); j++) {
                    if(j<plan.getAnios().size()){
                        System.out.println("Ingese el nombre del Año nro" + j + "");
                        System.out.println("Nombre Actual = "+plan.getAnios().get(j).getNombre());
                        
                        while(temp.isEmpty()){
                            temp = Main.scanner.nextLine();
                        }
                        if(!temp.isEmpty()){
                            plan.getAnios().get(j).setNombre(temp);
                        }
                        temp=new String();
                    }else{
                        System.out.println("Ingese el nombre del Año nro" + j + "");
                        while(temp.isEmpty()){
                            temp = Main.scanner.nextLine();
                        }
                        plan.getAnios().add(new AnioPlanImpl(plan, j, temp));
                        temp=new String();
                    }
                }
            }
            for (AnioPlan anioPlan : plan.getAnios()) {
                System.out.println("Ingrese la cantidad de materias en el año "+anioPlan.getNumero()+", cantidad actual=" + anioPlan.getMaterias().size() + ":");
                cant = Main.scanner.nextInt();
                if (cant < anioPlan.getMaterias().size()) {
                    for (int j = anioPlan.getMaterias().size(); j > cant; j--) {
                        anioPlan.getMaterias().remove(j);
                    }
                } else {
                    for (int j = 0; j < (cant + 1); j++) {
                        if (j < anioPlan.getMaterias().size()){
                            System.out.println("Ingese el nombre de la materia nro" + j + ":");
                            System.out.println("Nombre actual = "+anioPlan.getMaterias().get(j).getNombre());
                            while(temp.isEmpty()){
                                temp = Main.scanner.nextLine();
                            }
                            if(!temp.isEmpty()){
                                anioPlan.getMaterias().get(j).setNombre(temp);
                            }
                            temp=new String();
                            System.out.println("Ingrese la cacrga horaria de la materia nro");
                            System.out.println("Cantidad actual = "+anioPlan.getMaterias().get(j).getCargaHoraria());
                            tempb = Main.scanner.nextDouble();
                            if(tempb!=0){
                                anioPlan.getMaterias().get(j).setCargaHoraria(tempb);
                            }
                            tempb=0;
                        } else{
                            System.out.println("Ingese el nombre de la materia nro" + j + ":");
                            while(temp.isEmpty()){
                                temp = Main.scanner.nextLine();
                            }
                            System.out.println("Ingrese la cacrga horaria de la materia nro");
                            tempb = Main.scanner.nextDouble();
                            anioPlan.getMaterias().add(new MateriaImpl(anioPlan,j,temp,tempb));
                            tempb=0;
                            temp=new String();
                        }
                    }
                }
            }
        }
    }
}
