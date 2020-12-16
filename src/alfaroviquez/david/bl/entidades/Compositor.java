package alfaroviquez.david.bl.entidades;

/***
 * Esta clase define un objeto de tipo compositor
 * @author David Alfaro
 * @version 1.0
 * @since 28/11/2020
 */
public class Compositor {
    private int id;
    private String nombre;
    private String apellido1;
    private  int edad;
    private String paisNacimiento;
    private Genero genero;

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

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Compositor(){}

    /***
     * Constructor de la clase Compositor
     *
     * @param nombre este parametro defien el nombre del compositor
     * @param apellido1 este parametro define el primer apellido del compositor
     * @param edad este parametro define la edad del compositor
     * @param paisNacimiento este parametro define el pais de nacimiento del compositor
     * @param genero este parametro se refiere al genero que compone el compositor
     */
    public Compositor(String nombre, String apellido1, int edad, String paisNacimiento, Genero genero) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.edad = edad;
        this.paisNacimiento = paisNacimiento;
        this.genero=genero;
    }

    @Override
    public String toString() {
        return "Compositor{" +
                "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", edad=" + edad +
                ", paisNacimiento='" + paisNacimiento + '\'' +
                '}';
    }

    public String toCSVLine(){
        return this.nombre+","+this.apellido1+","+this.edad+","+this.paisNacimiento;
    }
}
