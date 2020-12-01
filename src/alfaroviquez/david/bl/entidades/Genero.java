package alfaroviquez.david.bl.entidades;

/***
 * Esta clase define un objeto de tipo Genero
 *
 * @author David Alfaro
 * @version 1.0
 * @since 28/11/2020
 */
public class Genero {
    private String nombre;
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Genero(){}

    /***
     * Constructor de la clase Genero
     *
     * @param nombre este parametro define el nombre del genero que se esta instanciando
     * @param descripcion este parametro define el una descripcion para el nuevo genero
     */
    public Genero(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public String toCSVLine(){
        return this.nombre+","+this.descripcion;
    }
}
