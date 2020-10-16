package alfaroviquez.david.bl.entidades;

public class Administrador extends Usuario {
    public Administrador() {
    }

    public Administrador(String nombre, String apellido1, String apellido2, String nombreUsuario, String correo, String contrasenna, String imagen) {
        super(nombre, apellido1, apellido2, nombreUsuario, correo, contrasenna, imagen);
    }

    @Override
    public String toString() {
        return "Administrador{} " + super.toString();
    }
}
