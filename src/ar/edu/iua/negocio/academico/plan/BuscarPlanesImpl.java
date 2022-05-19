package ar.edu.iua.negocio.academico.plan;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import ar.edu.iua.modelo.academico.plan.AnioPlan;
import ar.edu.iua.modelo.academico.plan.Materia;
import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.persistencia.BaseDeDatos;

public class BuscarPlanesImpl implements BuscarPlanes {
    public List<Plan> buscar(String terminos) {
        String[] listaTerminos=terminos.split(" ");

        List<Plan> resultados= new ArrayList<Plan>();
        for (int i=0; i<BaseDeDatos.getSize();i++) {
            //Plan
            for (String string : listaTerminos) {
                if(!string.isBlank()){
                    if(compareALL(clean(string),BaseDeDatos.get(i))){
                        if(resultados.indexOf(BaseDeDatos.get(i))<0){
                            resultados.add(BaseDeDatos.get(i));
                        }
                    }
                }
            }
        }
        return resultados;
    }

    private String clean(String string) {
        string = string.toLowerCase();
        //Separo acentos de vocales
        string = Normalizer.normalize(string, Normalizer.Form.NFD);
        //Elimino caracteres comprendidos entre U+0300 y U+036F (acentos, simbolos raros y comillas simples)
        string = string.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        //Elimino tambien comillas dobles
        string = string.replaceAll("\"", "");
        return string;
    }

    private boolean compareALL(String string, Plan plan) {
        boolean check=false;
        check=check||plan.getAnio().toString().contains(string);
        check=check||(plan.isEstadoActivo()?"activo":plan.isEstadoBorrador()?"borrador":plan.isEstadoNoActivo()?"no Activo":"desconocido").contains(string);
        for (AnioPlan anioPlan : plan.getAnios()) {
            check=check||anioPlan.getNumero().toString().contains(string);
            check=check||clean(anioPlan.getNombre()).contains(string);
            for (Materia materia : anioPlan.getMaterias()) {
                check=check||materia.getCodigo().toString().contains(string);
                check=check||clean(materia.getNombre()).contains(string);
                check=check||materia.getCargaHoraria().toString().contains(string);
            }
        }
        return check;
    }
    
}
