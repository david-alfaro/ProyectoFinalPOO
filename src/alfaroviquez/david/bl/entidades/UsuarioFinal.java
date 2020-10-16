package alfaroviquez.david.bl.entidades;

public class UsuarioFinal extends Usuario{
    private int edad;
    private String pais;
    private String identificacion;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public UsuarioFinal() {
    }

    public UsuarioFinal(String nombre, String apellido1, String apellido2, String nombreUsuario, String correo, String contrasenna, String imagen, int edad, String pais, String identificacion) {
        super(nombre, apellido1, apellido2, nombreUsuario, correo, contrasenna, imagen);
        this.edad = edad;
        this.pais = pais;
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "UsuarioFinal{" +
                "edad=" + edad +
                ", pais='" + pais + '\'' +
                ", identificacion='" + identificacion + '\'' +
                "} " + super.toString();
    }
}
