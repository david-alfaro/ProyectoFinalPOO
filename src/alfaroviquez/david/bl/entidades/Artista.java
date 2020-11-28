package alfaroviquez.david.bl.entidades;

import java.time.LocalDate;

public class Artista {
    private String nombre;
    private  String apellido1;
    private String nombreArtistico;
    private String paisNacimiento;
    private int edad;
    private String descripcion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaDefuncion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }


    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }



    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(LocalDate fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public  Artista(){}
    public Artista(String nombre, String apellido1,String nombreArtistico, String paisNacimiento, int edad, String descripcion, LocalDate fechaNacimiento, LocalDate fechaDefuncion) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.nombreArtistico = nombreArtistico;
        this.paisNacimiento = paisNacimiento;
        this.edad = edad;
        this.descripcion = descripcion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaDefuncion = fechaDefuncion;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", nombreArtistico='" + nombreArtistico + '\'' +
                ", paisNacimiento='" + paisNacimiento + '\'' +
                ", edad=" + edad +
                ", descripcion='" + descripcion + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", fechaDefuncion='" + fechaDefuncion + '\'' +
                '}';
    }

    public String toCSVLine(){
        return this.nombre+","+this.apellido1+","+this.nombreArtistico+","+this.paisNacimiento+","+this.edad+","+this.fechaNacimiento+","+this.fechaDefuncion+","+this.descripcion;
    }
}
