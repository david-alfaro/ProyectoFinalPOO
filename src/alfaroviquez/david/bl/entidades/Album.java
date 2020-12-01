package alfaroviquez.david.bl.entidades;

import java.util.ArrayList;

/***
 * Esta clase define un objeto de tipo album
 * @author David Alfaro v
 * @version 1.0
 * @since 28/11/2020
 */
public class Album {
    private String nombre;
    private ArrayList<Artista> artistas;
    private String fechalanzamiento;
    private String imagen;
    private ArrayList<Cancion> canciones;

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

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(ArrayList<Artista> artistas) {
        this.artistas = artistas;
    }

    public String getFechalanzamiento() {
        return fechalanzamiento;
    }

    public void setFechalanzamiento(String fechalanzamiento) {
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
     * @param artistas que estan en el album
     * @param fechalanzamiento del album
     * @param imagen del album
     * @param canciones que estan en el album
     */
    public Album(String nombre, ArrayList<Artista> artistas, String fechalanzamiento, String imagen, ArrayList<Cancion> canciones) {
        this.nombre = nombre;
        this.artistas = artistas;
        this.fechalanzamiento = fechalanzamiento;
        this.imagen = imagen;
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "Album{" +
                "nombre='" + nombre + '\'' +
                ", artistas=" + artistas +
                ", fechalanzamiento='" + fechalanzamiento + '\'' +
                ", imagen='" + imagen + '\'' +
                ", canciones=" + canciones +
                '}';
    }
}
