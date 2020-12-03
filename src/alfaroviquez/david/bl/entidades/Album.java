package alfaroviquez.david.bl.entidades;

import java.time.LocalDate;
import java.util.ArrayList;

/***
 * Esta clase define un objeto de tipo album
 * @author David Alfaro v
 * @version 1.0
 * @since 28/11/2020
 */
public class Album {
    private int id;
    private String nombre;
    private LocalDate fechalanzamiento;
    private String imagen;
    private ArrayList<Cancion> canciones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechalanzamiento() {
        return fechalanzamiento;
    }

    public void setFechalanzamiento(LocalDate fechalanzamiento) {
        this.fechalanzamiento = fechalanzamiento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public Album(){}

    /***
     * Constructor de la clase
     * @param nombre del album
     * @param fechalanzamiento del album
     * @param imagen del album
     * @param canciones este parametro se refiere a la lista de canciones que pertenecen al album
     */
    public Album(String nombre, LocalDate fechalanzamiento, String imagen, ArrayList<Cancion> canciones) {
        this.nombre = nombre;
        this.fechalanzamiento = fechalanzamiento;
        this.imagen = imagen;
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechalanzamiento=" + fechalanzamiento +
                ", imagen='" + imagen + '\'' +
                ", canciones=" + canciones +
                '}';
    }

    public String toCSVLine(){
        return this.id+","+this.nombre+","+this.fechalanzamiento+","+this.imagen;
    }
}
