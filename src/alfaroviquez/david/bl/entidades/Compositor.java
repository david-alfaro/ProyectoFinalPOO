package alfaroviquez.david.bl.entidades;

/***
 * Esta clase define un objeto de tipo compositor
 * @author David Alfaro
 * @version 1.0
 * @since 28/11/2020
 */
public class Compositor {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private  int edad;
    private String paisNacimiento;

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
    public Compositor(){}

    /***
     * Constructor de la clase Compositor
     *
     * @param nombre este parametro defien el nombre del compositor
     * @param apellido1 este parametro define el primer apellido del compositor
     * @param apellido2 este parametro define el segundo apellido del compositor
     * @param edad este parametro define la edad del compositor
     * @param paisNacimiento este parametro define el pais de nacimiento del compositor
     */
    public Compositor(String nombre, String apellido1, String apellido2, int edad, String paisNacimiento) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.paisNacimiento = paisNacimiento;
    }

    @Override
    public String toString() {
        return "Compositor{" +
                "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", edad=" + edad +
                ", paisNacimiento='" + paisNacimiento + '\'' +
                '}';
    }

    public String toCSVLine(){
        return this.nombre+","+this.apellido1+","+this.apellido2+","+this.edad+","+this.paisNacimiento;
    }
}
