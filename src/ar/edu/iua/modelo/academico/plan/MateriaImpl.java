package ar.edu.iua.modelo.academico.plan;

public class MateriaImpl extends Materia {

    private AnioPlan anio;
    private Integer codigo;
    private String nombre;
    private Double cargaHoraria;

    public MateriaImpl(AnioPlan anio, Integer codigo, String nombre, Double cargaHoraria) {
        this.anio = anio;
        this.codigo = codigo;
        this.nombre = nombre;
        this.cargaHoraria = cargaHoraria;
    }

    public AnioPlan getAnio() {
        return anio;
    }

    public void setAnio(AnioPlan anio) {
        this.anio = anio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = (nombre!=null)?nombre.trim():null;
        nombre = (nombre!=null&&nombre.length()==0)?null:nombre;
        this.nombre = nombre;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
        MateriaImpl other = (MateriaImpl) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

	@Override
    public String toString() {
        return (nombre!=null&&cargaHoraria!=null)?nombre+" "+cargaHoraria:(nombre!=null)?"Sin nombre "+cargaHoraria:(cargaHoraria!=null)?nombre:"Sin nombre";
        
    }



 
    
}