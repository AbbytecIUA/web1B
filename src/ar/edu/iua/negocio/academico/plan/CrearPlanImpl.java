package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.modelo.academico.plan.AnioPlan;
import ar.edu.iua.modelo.academico.plan.Materia;
import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.modelo.exceptions.CrearPlanEx;
import ar.edu.iua.persistencia.BaseDeDatos;

public class CrearPlanImpl implements CrearPlan {

    public boolean crear(Plan plan) throws CrearPlanEx {
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
                                    throw new CrearPlanEx("El numero de los años no es consecutivo");
                                }else{
                                    secuancia1=ap.getNumero();
                                }
                                if(ap.getNombre()==null || ap.getMaterias()==null || ap.getNumero()==null || !ap.getPlan().equals(plan)){
                                    throw new CrearPlanEx(ap.getNombre()==null?"Nombre del año es nulo":
                                    ap.getMaterias()==null?"La lista de materias es nula":
                                    ap.getNumero()==null?"El numero de año es nulo":"El año del plan no coincide con el plan asignado a dicho año");
                                }else{
                                    if(ap.getMaterias().isEmpty() || ap.getNumero()<=0){
                                        throw new CrearPlanEx(ap.getMaterias().isEmpty()?"Lista de materias vacia":"Numero de año menor o igual que 0");
                                    }else{
                                        secuencia2=0;
                                        for(Materia ma:ap.getMaterias()){
                                            if(ma.getNombre()==null || ma.getCargaHoraria()==null || ma.getCodigo()==null || !ma.getAnio().equals(ap)){
                                                throw new CrearPlanEx(ma.getNombre()==null?"El nombre de la materia nro "+plan.getAnios().indexOf(ap)+" es nulo":
                                                ma.getCargaHoraria()==null?"La carga horaria de la materia nro "+plan.getAnios().indexOf(ap)+" es nula":
                                                ma.getCodigo()==null?"El codigo de la materia nro "+plan.getAnios().indexOf(ap)+" es nulo":
                                                "El año de la materia nro "+plan.getAnios().indexOf(ap)+" no coincide con eñ año del plan actual");
                                            } else {
                                                if(secuencia2+1!=ma.getCodigo()){
                                                    throw new CrearPlanEx("El numero de materia no es consecutivo");
                                                }
                                                secuencia2++;
                                                if(ma.getCodigo()<=0 || ma.getCargaHoraria()<=0){
                                                    throw new CrearPlanEx(ma.getCodigo()<=0?"El codigo de la materia es menor o igual que 0":
                                                    "La carga horaria de la materia es menor o igual que 0");
                                                } else{
                                                    try {
                                                        Plan nuevo = (Plan) plan.clone();
                                                        BaseDeDatos.add(nuevo);                                                 
                                                        return true;
                                                    } catch (CloneNotSupportedException e) {
                                                        throw new CrearPlanEx("No se pudo clonar el elemento");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else{
                            throw new CrearPlanEx("La lista de años del plan está vacía");
                        }
                    } else{
                        throw new CrearPlanEx("El plan no está entre 1990 y 2040");
                    }
                } else{
                    throw new CrearPlanEx(plan.getAnio()==null?"El año del plan es nulo":"La lista de años en el plan es nula");
                }
            } else if(plan.isEstadoBorrador()){
                if(plan.getAnio()!=null){
                    if(plan.getAnio()<1990 && plan.getAnio()>2040){
                        throw new CrearPlanEx("El plan no está entre 1990 y 2040");
                    }
                }
                if(plan.getAnios()!=null){
                    if(!plan.getAnios().isEmpty()){
                        for(AnioPlan ap:plan.getAnios()){
                            if(ap.getPlan().equals(plan)==false){ 
                                throw new CrearPlanEx("El plan del año "+plan.getAnio()+" no coincide con el plan asignado al año "+ap.getNumero()+". Inconsistencia de datos");
                            }
                            if(ap.getNumero()!=null){
                                if(!(ap.getNumero()>0)){
                                    throw new CrearPlanEx("El año del plan es menor que 0");
                                }
                            }
                            if(ap.getMaterias()!=null){
                                if(!ap.getMaterias().isEmpty()){
                                    secuencia2=0;
                                    for(Materia ma:ap.getMaterias()){
                                        if(ma.getAnio().equals(ap) == false){
                                            throw new CrearPlanEx("El año de la materia "+ma.getAnio()+" no coincide con el año del plan dado. Inconsistencia de datos");
                                        }
                                        if(ma.getCodigo()!=null){
                                            if(secuencia2+1==ma.getCodigo()&&ma.getCodigo()>0){
                                                secuencia2++;
                                            }else{
                                                throw new CrearPlanEx(!(ma.getCodigo()>0)?"El codigo de la materia es menor o igual a 0":"El numero de materia no es consecutivo");
                                            }
                                        }
                                        if(ma.getCargaHoraria()!=null){
                                            if(ma.getCargaHoraria()<=0){
                                                throw new CrearPlanEx("La carga horaria de la materia es menor o igual que 0");
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
                    BaseDeDatos.add(nuevo);                                                 
                    return true;
                } catch (CloneNotSupportedException e) {
                    throw new CrearPlanEx("No se pudo clonar el elemento");
                }
            }
        }
        throw new CrearPlanEx("El plan es nulo");
    }

}
