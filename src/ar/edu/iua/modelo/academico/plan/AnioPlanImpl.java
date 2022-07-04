package ar.edu.iua.modelo.academico.plan;

import java.util.ArrayList;
import java.util.List;

public class AnioPlanImpl extends AnioPlan {
    private Integer numero;
    private String nombre;
    private List<MateriaImpl> materias = new ArrayList<MateriaImpl>();

    public AnioPlanImpl(Integer numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = (nombre != null && nombre.trim().length() > 0) ? nombre.trim() : null;
        this.nombre = nombre;
    }

    public List<MateriaImpl> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaImpl> materias) {
        this.materias = materias;
    }

    // ----

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AnioPlanImpl other = (AnioPlanImpl) obj;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }

    public String toString() {
        return nombre != null ? nombre : (numero != null ? "Año " + numero : "Año sin identificación");
    }

}
