package alfaroviquez.david.bl.entidades;

import java.util.ArrayList;
import java.util.Objects;

public class Cuenta {
    private String nombreCuenta;
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public Cuenta(){}

    public Cuenta(String nombreCuenta, ArrayList<Usuario> usuarios) {
        this.nombreCuenta = nombreCuenta;
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "nombreCuenta='" + nombreCuenta + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(nombreCuenta, cuenta.nombreCuenta) &&
                Objects.equals(usuarios, cuenta.usuarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreCuenta, usuarios);
    }
}
