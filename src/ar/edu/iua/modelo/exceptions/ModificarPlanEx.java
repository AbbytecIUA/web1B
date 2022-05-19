package ar.edu.iua.modelo.exceptions;

public class ModificarPlanEx extends ObjetoEx{

    /**
     *
     */
    private static final long serialVersionUID = -189393437071204072L;

    public ModificarPlanEx(String e){
        super("Error al modificar el plan: "+e);
    }
}