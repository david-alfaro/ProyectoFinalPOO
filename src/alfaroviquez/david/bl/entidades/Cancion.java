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


    public Cancion() {
    }

    /***
     * Constructor de la clase
     * @param nombre este parametro se refiere al nombre de la cancion
     * @param mp3 este parametro se refiere al archivo mp3 de la cancion
     * @param fechaLanzamiento este parametro se refiere a la fecha de lanzamiento de la cancion
     */
    public Cancion(String nombre, String mp3, LocalDate fechaLanzamiento) {
        this.nombre = nombre;
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
        return this.id+","+this.nombre + "," + this.mp3 + "," + this.fechaLanzamiento;
    }
}
