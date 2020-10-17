package alfaroviquez.david.bl.entidades;

import java.util.ArrayList;

public class ListaReproduccion {
    private ArrayList<Cancion> canciones;
    private String nombre;
    private  String fechaCreacion;



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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }



    public ListaReproduccion() {
    }

    public ListaReproduccion(ArrayList<Cancion> canciones, String nombre, String fechaCreacion, int calificacion) {
        this.canciones = canciones;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;

    }

    @Override
    public String toString() {
        return "ListaReproduccion{" +
                "canciones=" + canciones +
                ", nombre='" + nombre + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                '}';
    }

}
