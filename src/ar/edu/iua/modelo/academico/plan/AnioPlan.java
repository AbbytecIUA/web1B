package ar.edu.iua.modelo.academico.plan;

import java.util.List;

import ar.edu.iua.modelo.Objeto;

public abstract class AnioPlan extends Objeto {

    abstract public Integer getNumero();

    abstract public void setNumero(Integer numero);

    abstract public String getNombre();

    abstract public void setNombre(String nombre);

    abstract public List<MateriaImpl> getMaterias();

    abstract public void setMaterias(List<MateriaImpl> materias);

}
