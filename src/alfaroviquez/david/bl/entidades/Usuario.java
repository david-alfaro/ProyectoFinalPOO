package alfaroviquez.david.bl.entidades;

public class Usuario {
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected String nombreUsuario;
    protected String correo;
    protected String contrasenna;
    protected String imagen;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Usuario() {
    }

    public Usuario(String nombre, String apellido1, String apellido2, String nombreUsuario, String correo, String contrasenna, String imagen) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasenna = contrasenna;
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenna='" + contrasenna + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
