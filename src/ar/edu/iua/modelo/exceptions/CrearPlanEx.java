package ar.edu.iua.modelo.exceptions;

public class CrearPlanEx extends ObjetoEx{

    /**
     *
     */
    private static final long serialVersionUID = -5934809117349525528L;

    public CrearPlanEx(String e){
        System.err.println("Error al crear plan: "+e);
    }

}