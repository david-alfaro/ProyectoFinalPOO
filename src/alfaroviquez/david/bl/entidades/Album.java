package alfaroviquez.david.bl.entidades;

import java.util.ArrayList;

public class Album {
    private String nombre;
    private Artista artista;
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

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
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

    public Album(String nombre, Artista artista, String fechalanzamiento, String imagen, ArrayList<Cancion> canciones) {
        this.nombre = nombre;
        this.artista = artista;
        this.fechalanzamiento = fechalanzamiento;
        this.imagen = imagen;
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "Album{" +
                "nombre='" + nombre + '\'' +
                ", artista=" + artista +
                ", fechalanzamiento='" + fechalanzamiento + '\'' +
                ", imagen='" + imagen + '\'' +
                ", canciones=" + canciones +
                '}';
    }
}
