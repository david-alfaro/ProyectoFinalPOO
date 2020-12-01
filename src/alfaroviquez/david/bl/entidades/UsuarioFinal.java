package alfaroviquez.david.bl.entidades;

/***
 * Esta clase define un objeto de tipo Usuario
 *
 * @author David Alfaro
 * @version 1.0
 * @since 28/11/2020
 */
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

    /***
     * Constructor de la clase UsuarioFinal
     *
     * @param nombre este parametro define el nombre que va a tneer el usuario
     * @param apellido1 este parametro define el primero apellido del usuario
     * @param apellido2 este parametro define el segundo apellido del usuario
     * @param nombreUsuario este parametro define el nombre de usuario del usuario
     * @param correo este parametro define el correo electronico que indique el usuario
     * @param contrasenna este parametro define la contrasenna indicada por el usuario
     * @param imagen este parametro es la imagen de perfil
     * @param edad este parametro define la edad del usuario
     * @param pais este parametro define el pais en donde se encuentra el usuario
     * @param identificacion este parametro define la identificacion del usuario
     */
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

    public String toCSVLine(){
        return this.nombre+","+this.apellido1+","+this.apellido2+","+this.nombreUsuario+","+this.correo+","+this.contrasenna+","+this.edad+","+this.pais+","+this.identificacion;
    }
}
