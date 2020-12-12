package alfaroviquez.david.bl.entidades;

import java.time.LocalDate;

/***
 * Esta clase crea un objeto de tipo Cancion
 * @author David Alfaro V
 * @version 1.0
 * @since 20/11/2020
 */
public class Cancion {
    private int id;
    private String nombre;
    private Artista artista;
    private Genero genero;
    private Compositor compositor;
    private Album album;
    private String mp3;
    private LocalDate fechaLanzamiento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Compositor getCompositor() {
        return compositor;
    }

    public void setCompositor(Compositor compositor) {
        this.compositor = compositor;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Cancion() {
    }

    /**
     * Constructor de la clase cancion

     * @param nombre este parametro se refiere al nombre de la cancion
     * @param artista este parametro se refiere al artista que canta la cancion
     * @param genero este parametro se refiere al genero que pertenece la cancion
     * @param compositor este parametro se refiere al compositor de la cancion
     * @param album este parametro se refiere al album al que pertenece la cancion
     * @param mp3 este parametro se refiere al lin mp3
     * @param fechaLanzamiento la fecha en que fue lanzada la cancion
     */

    public Cancion(String nombre, Artista artista, Genero genero, Compositor compositor, Album album, String mp3, LocalDate fechaLanzamiento) {
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.compositor = compositor;
        this.album = album;
        this.mp3 = mp3;
        this.fechaLanzamiento = fechaLanzamiento;
    }



    @Override
    public String toString() {
        return "Cancion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", mp3='" + mp3 + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                '}';
    }

    public String toCSVLine() {
        return this.nombre + "," + this.mp3 + "," + this.fechaLanzamiento;
    }
}
