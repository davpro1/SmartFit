package pojos;

public class Anatomia_Paciente {
    private Integer idAnatomiaPaciente;
    private Double peso;
    private Double estatura;
    private Double talla;
    private Integer idPaciente;
    private String paciente;
    
    public Anatomia_Paciente(){
        
    }

    public Integer getIdAnatomiaPaciente() {
        return idAnatomiaPaciente;
    }

    public void setIdAnatomiaPaciente(Integer idAnatomiaPaciente) {
        this.idAnatomiaPaciente = idAnatomiaPaciente;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getEstatura() {
        return estatura;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public Double getTalla() {
        return talla;
    }

    public void setTalla(Double talla) {
        this.talla = talla;
    }
    
    
}
