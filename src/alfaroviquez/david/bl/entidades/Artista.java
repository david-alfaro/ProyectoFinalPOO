package alfaroviquez.david.bl.entidades;

public class Artista {
    private String nombre;
    private  String apellido1;
    private String apellido2;
    private String nombreArtistico;
    private String paisNacimiento;
    private String genero;
    private int edad;
    private String descripcion;
    private String fechaNacimiento;
    private String fechaDefuncion;

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

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(String fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }
    public void Artista(){}

    public Artista(String nombre, String apellido1, String apellido2, String nombreArtistico, String paisNacimiento, String genero, int edad, String descripcion, String fechaNacimiento, String fechaDefuncion) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombreArtistico = nombreArtistico;
        this.paisNacimiento = paisNacimiento;
        this.genero = genero;
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
                ", apellido2='" + apellido2 + '\'' +
                ", nombreArtistico='" + nombreArtistico + '\'' +
                ", paisNacimiento='" + paisNacimiento + '\'' +
                ", genero='" + genero + '\'' +
                ", edad=" + edad +
                ", descripcion='" + descripcion + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", fechaDefuncion='" + fechaDefuncion + '\'' +
                '}';
    }
}
