package pojos;


public class TipoGenero {
    
    private Integer idGenero;
    private String nombre;
    
    public TipoGenero(){
    }

    public TipoGenero(Integer idGenero, String nombre) {
        this.idGenero = idGenero;
        this.nombre = nombre;
    }
    
        public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
