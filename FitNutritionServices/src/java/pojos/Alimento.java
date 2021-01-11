package pojos;

public class Alimento {
    
    private Integer idAlimento;
    private String nombre;
    private Double calorias;
    private Integer idTipoPorcion;
    private String porcion;
    
    public Alimento(){
        
    }

    public Integer getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Integer idAlimento) {
        this.idAlimento = idAlimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCalorias() {
        return calorias;
    }

    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }

    public Integer getIdTipoPorcion() {
        return idTipoPorcion;
    }

    public void setIdTipoPorcion(Integer idTipoPorcion) {
        this.idTipoPorcion = idTipoPorcion;
    }

    public String getPorcion() {
        return porcion;
    }

    public void setPorcion(String porcion) {
        this.porcion = porcion;
    }
    
    
}
