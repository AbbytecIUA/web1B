package ar.edu.iua.interfazusuario;

import java.util.ArrayList;
import java.util.List;

import ar.edu.iua.Main;
import ar.edu.iua.modelo.academico.plan.AnioPlanImpl;
import ar.edu.iua.modelo.academico.plan.MateriaImpl;
import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.modelo.academico.plan.PlanImpl;
import ar.edu.iua.modelo.exceptions.CrearPlanEx;
import ar.edu.iua.negocio.academico.plan.BuscarPlan;
import ar.edu.iua.negocio.academico.plan.BuscarPlanImpl;
import ar.edu.iua.negocio.academico.plan.CrearPlanes;
import ar.edu.iua.negocio.academico.plan.CrearPlanesImpl;
import ar.edu.iua.util.GenerarEjemplosDePlanes;

public class CrearPlanesMenu {
    public CrearPlanesMenu() throws CrearPlanEx {
        int i=-1, cant;
        while(i!=0){
            System.out.println("Presione 1 para generar los planes default, 2 para crearlos manualmente o 0 para volver al menu anterior");
            i=Main.scanner.nextInt();
            if(i!=0){
                System.out.println("Ingrese la cantidad de planes a crear:");
                cant=Main.scanner.nextInt();
                List<Plan> planes=null;
                if(i==1){
                    planes = GenerarEjemplosDePlanes.generar(cant, false);        
                    System.out.println("\n\nSe crearon " + planes.size() + " planes.");
                    
                }
                if(i==2){
                    planes = crearPlanesManualmente(cant);
                }

                CrearPlanes crearPlanes = new CrearPlanesImpl();
                if(crearPlanes.crear(planes)){
                    System.out.println("Operación realizada correctamente!");
                }else{
                    System.err.println("No se pudo realizar la operación!");
                }
            }
            
        }
    }

    private List<Plan> crearPlanesManualmente(int cant) {
        List<Plan> planes = new ArrayList<Plan>();
        List<AnioPlanImpl> anioPlanes;
        List<MateriaImpl> materias;

        Plan temp;
        AnioPlanImpl tempAnio;
        MateriaImpl tempMateria;

        int cantAños,cantMaterias;
        String nombreTemp=new String();
        double cargaHorariaTemp;

        for (int j=0;j<cant;j++) {
            temp = new PlanImpl();
            anioPlanes = new ArrayList<AnioPlanImpl>();
            System.out.println("Ingrese el numero de año del plan nro "+j+":");
            temp.setAnio(Main.scanner.nextInt());
            BuscarPlan bp=new BuscarPlanImpl();
            if(bp.buscar(temp.getAnio())==null){
                System.out.println("Ingrese el estado del plan(1- Borrador, 2- Activo, 3- No Activo)");
                
                switch(Main.scanner.nextInt()){
                    default: 
                        System.out.println("Seleccionado Borrador");
                        temp.setEstadoBorrador();
                        break;
                    case 2:
                        temp.setEstadoActivo();
                        break;
                    case 3:
                        temp.setEstadoNoActivo();
                        break;
                }

                System.out.println("Ingrese la cantidad de años en el plan "+j+":");
                cantAños=Main.scanner.nextInt();
                for(int k=1;k<(cantAños+1);k++){
                    System.out.println("Ingrese el nombre textual para el Año numero "+k+":");
                    String tempString=new String();
                    while(tempString.isEmpty()){
                        tempString = Main.scanner.nextLine();
                    }
                    tempAnio = new AnioPlanImpl(k, tempString);
                    System.out.println("Ingrese la cantidad de materias para ese año:");
                    cantMaterias=Main.scanner.nextInt();
                    materias=new ArrayList<MateriaImpl>();
                    for(int l=1;l<(cantMaterias+1);l++){
                        System.out.println("Ingrese el nombre de la materia "+l+":");
                        while(!Main.scanner.hasNextLine()){
                            nombreTemp = Main.scanner.nextLine();
                        }
                        System.out.println("Ingrese la carga horaria de la materia "+l+":");
                        cargaHorariaTemp = Main.scanner.nextDouble();
                        tempMateria=new MateriaImpl(l, nombreTemp, cargaHorariaTemp);
                        materias.add(tempMateria);
                    }
                    tempAnio.setMaterias(materias);
                    anioPlanes.add(tempAnio);

                }
                temp.setAnios(anioPlanes);
                planes.add(temp);
            } else{
                System.out.println("El año ya existe");
            }
            
        }
        return planes;
    }
}
