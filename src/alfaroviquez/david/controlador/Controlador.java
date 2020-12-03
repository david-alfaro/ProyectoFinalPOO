package alfaroviquez.david.controlador;

import alfaroviquez.david.bl.entidades.*;
import alfaroviquez.david.bl.logica.Gestor;
import alfaroviquez.david.iu.IU;

import java.time.LocalDate;


public class Controlador {
    private IU interfaz = new IU();
    private Gestor gestor = new Gestor();

    public void ejecutarPrograma() {
        int opcion = 0;
        do {
            interfaz.menu();
            opcion = interfaz.leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearAdmin();
                break;
            case 2:
                registrarUsuario();
                break;
            case 3:
                listarUsuarios();
                break;
            case 4:
                registrarArtista();
                break;
            case 5:
                listarArtistas();
                break;
            case 6:
                registrarGenero();
                break;
            case 7:
                listarGeneros();
                break;
            case 8:
                registrarCompositor();
                break;
            case 9:
                listarCompositores();
                break;
            case 10:
                registrarCancion();
                break;
            case 11:
                listarCanciones();
                break;
            case 12:
                crearListaReproduccion();
                break;
            case 13:
                listarListaReproduccion();
                break;
            case 14:
                crearAlbum();
                break;
            case 15:
                listarAlbums();
                break;
            case 16:
                agregarCancionAAlbum();
                break;
            case 0:
                break;
            default:
                interfaz.imprimirMensaje("Opción inválida");
        }
    }


    private void registrarUsuario() {
        interfaz.imprimirMensaje("Nombre: ");
        String nombre = interfaz.leerTexto();
        interfaz.imprimirMensaje("Primer apellido: ");
        String apellido1 = interfaz.leerTexto();
        interfaz.imprimirMensaje("Segundo apellido: ");
        String apellido2 = interfaz.leerTexto();
        interfaz.imprimirMensaje("Nombre de usuario: ");
        String nombreUsuario = interfaz.leerTexto();
        interfaz.imprimirMensaje("Correo: ");
        String correo = interfaz.leerTexto();
        interfaz.imprimirMensaje("Contraseña: ");
        String contrasenna = interfaz.leerTexto();
        interfaz.imprimirMensaje("Imagen de perfil o ávatar: ");
        String imagen = interfaz.leerTexto();
        interfaz.imprimirMensaje("Edad: ");
        int edad = interfaz.leerNumeros();
        interfaz.imprimirMensaje("Pais de origen: ");
        String pais = interfaz.leerTexto();
        interfaz.imprimirMensaje("Identificación: ");
        String identificacion = interfaz.leerTexto();
        if (edad >= 18) {
            gestor.registroUsuario(nombre,apellido1,apellido2,nombreUsuario,correo,contrasenna,imagen,edad,pais,identificacion);
        } else {
            interfaz.imprimirMensaje("No se puede registrar el usario, debe ser mayor de edad");
        }
    }

    private void crearAdmin() {
        interfaz.imprimirMensaje("Nombre: ");
        String nombre = interfaz.leerTexto();
        interfaz.imprimirMensaje("Primer apellido: ");
        String apellido1 = interfaz.leerTexto();
        interfaz.imprimirMensaje("Segundo apellido: ");
        String apellido2 = interfaz.leerTexto();
        interfaz.imprimirMensaje("Nombre de usuario: ");
        String nombreUsuario = interfaz.leerTexto();
        interfaz.imprimirMensaje("Correo: ");
        String correo = interfaz.leerTexto();
        interfaz.imprimirMensaje("Contraseña: ");
        String contrasenna = interfaz.leerTexto();
        interfaz.imprimirMensaje("Imagen de perfil o ávatar: ");
        String imagen = interfaz.leerTexto();
        Administrador admin = new Administrador(nombre, apellido1, apellido2, nombreUsuario, correo, contrasenna, imagen);

    }

    private void listarUsuarios() {
        for (UsuarioFinal ususario : gestor.listaRUsuarios()
        ) {
            interfaz.imprimirMensaje(ususario.toCSVLine());

        }
    }

    private void registrarArtista() {
        interfaz.imprimirMensaje("Nombre: ");
        String nombre = interfaz.leerTexto();
        interfaz.imprimirMensaje("Primer apellido: ");
        String apellido1 = interfaz.leerTexto();
        interfaz.imprimirMensaje("Nombre artístico: ");
        String nombreArtistico = interfaz.leerTexto();
        interfaz.imprimirMensaje("Pais de origen: ");
        String pais = interfaz.leerTexto();
        interfaz.imprimirMensaje("Edad: ");
        int edad = interfaz.leerNumeros();
        interfaz.imprimirMensaje("Descripción: ");
        String descripcion = interfaz.leerTexto();
        interfaz.imprimirMensaje("Fecha de nacimiento: ");
        String fechaNacimiento = interfaz.leerTexto();
        LocalDate fechaNac = obtenerFecha(fechaNacimiento);
        interfaz.imprimirMensaje("Fallecido? (s/n) ");
        String respuesta = interfaz.leerTexto();
        LocalDate fechaDef = null;
        String fechaDefuncion ="";
        if(respuesta.equalsIgnoreCase("s")){
            interfaz.imprimirMensaje("Fecha de defunción: ");
            fechaDefuncion = interfaz.leerTexto();
            fechaDef = obtenerFecha(fechaDefuncion);

        }else{

        }

        gestor.registroArtistas(nombre,apellido1,nombreArtistico,pais,edad,descripcion,fechaNac,fechaDef);
        interfaz.imprimirMensaje("Artista registrado");

    }

    private void listarArtistas() {
        for (Artista artista : gestor.listarArtistas()
        ) {
            interfaz.imprimirMensaje(artista.toCSVLine());
        }
    }

    private void registrarGenero() {
        interfaz.imprimirMensaje("Nombre: ");
        String nombre = interfaz.leerTexto();
        interfaz.imprimirMensaje("Descripción: ");
        String descripcion = interfaz.leerTexto();
        gestor.guardarGenero(nombre,descripcion);
        interfaz.imprimirMensaje("Genero musical resitrado con exito");
    }

    private void listarGeneros() {
        for (Genero genero : gestor.listaGeneros()
        ) {
            interfaz.imprimirMensaje(genero.toCSVLine());
        }
    }

    private void registrarCompositor() {
        interfaz.imprimirMensaje("Nombre: ");
        String nombre = interfaz.leerTexto();
        interfaz.imprimirMensaje("Primer apellido: ");
        String apellido1 = interfaz.leerTexto();
        interfaz.imprimirMensaje("Segundo apellido: ");
        String apellido2 = interfaz.leerTexto();
        interfaz.imprimirMensaje("Edad: ");
        int edad = interfaz.leerNumeros();
        interfaz.imprimirMensaje("Pais de origen: ");
        String pais = interfaz.leerTexto();
        gestor.registroCompositor(nombre,apellido1,apellido2,edad,pais);
        interfaz.imprimirMensaje("Compositor registrado");
    }

    private void listarCompositores() {
        for (Compositor comp : gestor.listarCompositores()
        ) {
            interfaz.imprimirMensaje(comp.toCSVLine());

        }
    }

    private void registrarCancion() {
        interfaz.imprimirMensaje("Nombre de la canción: ");
        String nombreCancion = interfaz.leerTexto();
        interfaz.imprimirMensaje("Fecha lanzamiento: ");
        String fecha = interfaz.leerTexto();
        interfaz.imprimirMensaje("Ingrese la cancion-->");
        //en estos momentos se esta probando con un string como link de la cancion
        String mp3 = interfaz.leerTexto();
        LocalDate fechaLanzamiento = obtenerFecha(fecha);
        gestor.guardarCancion(nombreCancion,mp3,fechaLanzamiento);
        interfaz.imprimirMensaje("Cancion creada!");


    }

    public void listarCanciones() {
        interfaz.imprimirMensaje("Lista de canciones --> ");
        for (Cancion cancion : gestor.listaCanciones()
        ) {
            interfaz.imprimirMensaje(cancion.toCSVLine());
        }
    }

    public void crearListaReproduccion() {
        interfaz.imprimirMensaje("Nombre: ");
        String nombreLista = interfaz.leerTexto();
        interfaz.imprimirMensaje("Fecha de creación: ");
        String fecha = interfaz.leerTexto();
        ListaReproduccion nuevaLista = new ListaReproduccion();
        nuevaLista.setNombre(nombreLista);
        nuevaLista.setFechaCreacion(fecha);
        boolean agregarcancion = true;
        do{
            interfaz.imprimirMensaje("Nombre de canción: ");
            String nombreCancion = interfaz.leerTexto();
            Cancion unaCancion = gestor.encontrarCancion(nombreCancion);
            gestor.agregarCancion(nombreLista, unaCancion);
            interfaz.imprimirMensaje("Desea agregar una nueva canción (s/n): ");
            String opcion = interfaz.leerTexto();
            if (opcion.toLowerCase().equals("n")){
                agregarcancion=false;
            }
        }while (agregarcancion);

        gestor.guardarLista(nuevaLista);
        //interfaz.imprimirMensaje("El promedio de calificacion de esta lista es: ");
        //gestor.puntajeLista(nuevaLista);


    }

    public void listarListaReproduccion() {
        for (ListaReproduccion repro : gestor.listarListasReproduccion()
        ) {
            interfaz.imprimirMensaje(repro.toString());
        }
    }

    public void crearAlbum() {
        interfaz.imprimirMensaje("Nombre del album: ");
        String nombreAlbum = interfaz.leerTexto();
        interfaz.imprimirMensaje("Fecha de lanzamiento: ");
        String fecha = interfaz.leerTexto();
        LocalDate fechaLanzamiento = obtenerFecha(fecha);
        interfaz.imprimirMensaje("Imagen del album: ");
        //De momento la imagen se maneja escribiendo un String
        String imagenAlbum = interfaz.leerTexto();
        gestor.guardarAlbum(nombreAlbum,fechaLanzamiento,imagenAlbum);
        interfaz.imprimirMensaje("Nuevo Album ha sido creado");

    }

    public void listarAlbums() {
        for (Album album : gestor.listarAlbums()
        ) {
            interfaz.imprimirMensaje(album.toCSVLine());
        }
    }

    public void agregarCancionAAlbum(){
        interfaz.imprimirMensaje("Escoja una cancion: ");
        listarCanciones();
        interfaz.imprimirMensaje("Ingrese el nombre de la cancion a agregar");
        String nombreCancion = interfaz.leerTexto();
        interfaz.imprimirMensaje("Escoja un album: ");
        listarAlbums();
        interfaz.imprimirMensaje("Ingrese el nombre del album al que se le agregara la cancion: ");
        String nombreAlbum = interfaz.leerTexto();
        gestor.agregarCancionaAlbum(nombreCancion,nombreAlbum);
        interfaz.imprimirMensaje("Se agrego la cancion "+nombreCancion+" al album "+nombreAlbum);
    }

    private LocalDate obtenerFecha(String fecha){
        return LocalDate.parse(fecha);
    }

}
