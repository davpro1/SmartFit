package pojos;

public class Medico {
    
    private Integer idMedico;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private Integer idGenero;
    private String genero;
    private String domicilio;
    private String numeroPersonal;
    private Integer numeroCedula;
    private String contraseña;
    private Integer idEstado;
    private String estado;
    private byte[] fotografia;
    
    public Medico(){
        
    }

    public Medico(Integer idMedico, String nombre, String apellidos, String fechaNacimiento, Integer idGenero, String genero, String domicilio, String numeroPersonal, Integer numeroCedula, String contraseña, Integer idEstado, String estado) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.idGenero = idGenero;
        this.genero = genero;
        this.domicilio = domicilio;
        this.numeroPersonal = numeroPersonal;
        this.numeroCedula = numeroCedula;
        this.contraseña = contraseña;
        this.idEstado = idEstado;
        this.estado = estado;
    }
    
    

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNumeroPersonal() {
        return numeroPersonal;
    }

    public void setNumeroPersonal(String numeroPersonal) {
        this.numeroPersonal = numeroPersonal;
    }

    public Integer getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(Integer numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public byte[] getFotografia() {
        return fotografia;
    }

    public void setFotografia(byte[] fotografia) {
        this.fotografia = fotografia;
    }
}
