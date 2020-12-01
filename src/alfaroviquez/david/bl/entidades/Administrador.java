package alfaroviquez.david.bl.entidades;

/***
 * Esta clase defien un obetjo de tipo administrador
 * @author David Alfaro
 * @version 1.0
 * @since 28/11/2020
 */
public class Administrador extends Usuario {
    public Administrador() {
    }

    /***
     * Constructor de la clase
     * @param nombre del administrador
     * @param apellido1 del administrador
     * @param apellido2 del administrador
     * @param nombreUsuario del administrador
     * @param correo del administrador
     * @param contrasenna para inicio de sesion
     * @param imagen para el perfil
     */
    public Administrador(String nombre, String apellido1, String apellido2, String nombreUsuario, String correo, String contrasenna, String imagen) {
        super(nombre, apellido1, apellido2, nombreUsuario, correo, contrasenna, imagen);
    }

    @Override
    public String toString() {
        return "Administrador{} " + super.toString();
    }
}
