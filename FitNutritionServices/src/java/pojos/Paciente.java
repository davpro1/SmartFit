package pojos;

public class Paciente {
    private Integer idPaciente;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private Integer idGenero;
    private String genero;
    private String email;
    private String telefono;
    private String domicilio;
    private String usuario;
    private String contraseña;
    private byte[] fotoPaciente;
    private Integer idMedico;
    private String medico;
    
    public Paciente(){
        
    }

    public Paciente(Integer idPaciente, String nombre, String apellidos, String fechaNacimiento, Integer idGenero, String genero, String email, String telefono, String domicilio, String usuario, String contraseña, byte[] fotoPaciente, Integer idMedico, String medico) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.idGenero = idGenero;
        this.genero = genero;
        this.email = email;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.fotoPaciente = fotoPaciente;
        this.idMedico = idMedico;
        this.medico = medico;
    }
    
        public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public byte[] getFotoPaciente() {
        return fotoPaciente;
    }

    public void setFotoPaciente(byte[] fotoPaciente) {
        this.fotoPaciente = fotoPaciente;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }
    
    
}
