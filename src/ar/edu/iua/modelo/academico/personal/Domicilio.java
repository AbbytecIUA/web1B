package ar.edu.iua.modelo.academico.personal;

public class Domicilio {
    private String calle_numero;
    private String ciudad;
    private String provincia;
    private String codigoPostal;
    private String telefono;
    
    public Domicilio(String calle_numero, String ciudad, String provincia, String codigoPostal, String telefono) {
        this.calle_numero = calle_numero;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
    }

    public String getCalle_numero() {
        return calle_numero;
    }
    public void setCalle_numero(String calle_numero) {
        this.calle_numero = calle_numero;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
