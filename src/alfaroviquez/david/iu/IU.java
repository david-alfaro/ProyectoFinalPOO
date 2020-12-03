package alfaroviquez.david.iu;

import java.io.PrintStream;
import java.util.Scanner;

public class IU {
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in).useDelimiter("\n");

    public void menu() {
        output.println("******  MusicApp  *******");
        output.println("1. Crear administrador");
        output.println("2. Registrar usuario");
        output.println("3. Listar usuarios");
        output.println("4. Registrar artista");
        output.println("5. Listar artistas");
        output.println("6. Registrar genero");
        output.println("7. Listar generos");
        output.println("8. Registrar compositor");
        output.println("9. Listar compositores");
        output.println("10. Registrar cancion");
        output.println("11. Listar canciones");
        output.println("12. Crear lista de reproduccion");
        output.println("13. Listar listas de reproduccion");
        output.println("14. Crear Album");
        output.println("15. Listar Albums");
        output.println("16. Asignar cancion a album");
        output.println("0. Salir");

    }

    public int leerOpcion() {
        output.println("Su opcion es: ");
        return input.nextInt();
    }

    public void imprimirMensaje(String mensaje) {
        output.println(mensaje);
    }

    public String leerTexto() {
        return input.next();
    }


    public int leerNumeros() {
        return input.nextInt();
    }
}
