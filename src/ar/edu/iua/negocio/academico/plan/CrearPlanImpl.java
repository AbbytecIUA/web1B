package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.modelo.academico.plan.AnioPlan;
import ar.edu.iua.modelo.academico.plan.Materia;
import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.persistencia.BaseDeDatos;

public class CrearPlanImpl implements CrearPlan {

    public boolean crear(Plan plan) {
        int secuancia1=0,secuencia2=0;
        if(plan!=null){
            if(plan.isEstadoActivo()||plan.isEstadoNoActivo()){
                if(plan.getAnio()!=null && plan.getAnios()!=null){
                    if(plan.getAnio()>=1990 && plan.getAnio()<=2040){
                        if(!plan.getAnios().isEmpty()){
                            for(AnioPlan ap:plan.getAnios()){
                                if(secuancia1==0){
                                    secuancia1=ap.getNumero();
                                }else if(ap.getNumero()<secuancia1){
                                    System.err.println("Error: El numero de los años no es consecutivo");
                                    return false;
                                }else{
                                    secuancia1=ap.getNumero();
                                }
                                if(ap.getNombre()==null || ap.getMaterias()==null || ap.getNumero()==null || !ap.getPlan().equals(plan)){
                                    System.err.println(ap.getNombre()==null?"Error: Nombre del año es nulo":ap.getMaterias()==null?"Error: La lista de materias es nula":ap.getNumero()==null?"Error: El numero de año es nulo":"Error: El año del plan no coincide con el plan asignado a dicho año");
                                    return false;
                                }else{
                                    if(ap.getMaterias().isEmpty() || ap.getNumero()<=0){
                                        System.err.println(ap.getMaterias().isEmpty()?"Error: Lista de materias vacia":"Error numero de año menor o igual que 0");
                                        return false;
                                    }else{
                                        secuencia2=0;
                                        for(Materia ma:ap.getMaterias()){
                                            if(ma.getNombre()==null || ma.getCargaHoraria()==null || ma.getCodigo()==null || !ma.getAnio().equals(ap)){
                                                System.err.println(ma.getNombre()==null?"Error: El nombre de la materia nro "+plan.getAnios().indexOf(ap)+" es nulo":
                                                ma.getCargaHoraria()==null?"Error: La carga horaria de la materia nro "+plan.getAnios().indexOf(ap)+" es nula":
                                                ma.getCodigo()==null?"Error: El codigo de la materia nro "+plan.getAnios().indexOf(ap)+" es nulo":
                                                "Error: El año de la materia nro "+plan.getAnios().indexOf(ap)+" no coincide con eñ año del plan actual");
                                                return false;
                                            } else {
                                                if(secuencia2+1!=ma.getCodigo()){
                                                    System.err.println("Error: El numero de materia no es consecutivo");
                                                    return false;
                                                }
                                                secuencia2++;
                                                if(ma.getCodigo()<=0 || ma.getCargaHoraria()<=0){
                                                    System.err.println(ma.getCodigo()<=0?"Error: El codigo de la materia es menor o igual que 0":"Error: La carga horaria de la materia es menor o igual que 0");
                                                    return false;
                                                } else{
                                                    try {
                                                        Plan nuevo = (Plan) plan.clone();
                                                        BaseDeDatos.planes.add(nuevo);                                                 
                                                        return true;
                                                    } catch (CloneNotSupportedException e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else{
                            System.err.println("Error: La lista de años del plan está vacía");;
                        }
                    } else{
                        System.err.println("Error: El plan no está entre 1990 y 2040");
                    }
                } else{
                    System.err.println(plan.getAnio()==null?"Error: El año del plan es nulo":"Error: La lista de años en el plan es nula");
                }
            } else if(plan.isEstadoBorrador()){
                if(plan.getAnio()!=null){
                    if(plan.getAnio()<1990 && plan.getAnio()>2040){
                        System.err.println("Error: El plan no está entre 1990 y 2040");
                        return false;
                    }
                }
                if(plan.getAnios()!=null){
                    if(!plan.getAnios().isEmpty()){
                        for(AnioPlan ap:plan.getAnios()){
                            if(ap.getPlan().equals(plan)==false){ 
                                System.err.println("Error: El plan del año "+plan.getAnio()+" no coincide con el plan asignado al año "+ap.getNumero()+". Inconsistencia de datos");
                                return false;
                            }
                            if(ap.getNumero()!=null){
                                if(!(ap.getNumero()>0)){
                                    System.err.println("Error: El año del plan es menor que 0");
                                    return false;
                                }
                            }
                            if(ap.getMaterias()!=null){
                                if(!ap.getMaterias().isEmpty()){
                                    secuencia2=0;
                                    for(Materia ma:ap.getMaterias()){
                                        if(ma.getAnio().equals(ap) == false){
                                            System.err.println("Error: El año de la materia "+ma.getAnio()+" no coincide con el año del plan dado. Inconsistencia de datos");
                                            return false;
                                        }
                                        if(ma.getCodigo()!=null){
                                            if(secuencia2+1==ma.getCodigo()&&ma.getCodigo()>0){
                                                secuencia2++;
                                            }else{
                                                System.err.println(!(ma.getCodigo()>0)?"Error: El codigo de la materia es menor o igual a 0":"Error: El numero de materia no es consecutivo");
                                                return false;
                                            }
                                        }
                                        if(ma.getCargaHoraria()!=null){
                                            if(ma.getCargaHoraria()<=0){
                                                System.err.println("Error: La carga horaria de la materia es menor o igual que 0");
                                                return false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                try {
                    Plan nuevo = (Plan) plan.clone();
                    BaseDeDatos.planes.add(nuevo);                                                 
                    return true;
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.err.println("Error: El plan es nulo");
        return false;
    }

}
