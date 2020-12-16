package alfaroviquez.david.controlador;

import alfaroviquez.david.bl.entidades.*;
import alfaroviquez.david.bl.logica.Gestor;
import alfaroviquez.david.iu.IU;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;


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
                //crearAdmin();
                break;
            case 2:
                //registrarUsuario();
                break;
            case 3:
                listarUsuarios();
                break;
            case 4:
                //registrarArtista();
                break;
            case 5:
                listarArtistas();
                break;
            case 6:
                //registrarGenero();
                break;
            case 7:
                listarGeneros();
                break;
            case 8:
                //registrarCompositor();
                break;
            case 9:
                listarCompositores();
                break;
            case 10:
                //registrarCancion();
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
                //crearAlbum();
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


    public void registrarUsuario(String nombre, String apellido1, String apellido2, String nombreUsuario, String correo, String contrasenna, String imagen,LocalDate fechaNac, String pais, String identificacion ) {
        /*
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
        }*/
        int edadUser = Period.between(fechaNac,LocalDate.now()).getYears();
        gestor.registroUsuario(nombre,apellido1,apellido2,nombreUsuario,correo,contrasenna,imagen,edadUser,pais,identificacion);
    }

    public void crearAdmin(String nombre, String nombreUsuario , String apellido1, String apellido2, String correo, String contrasenna, String imagen) {
        /*interfaz.imprimirMensaje("Nombre: ");
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
        String imagen = interfaz.leerTexto();*/
        gestor.registrarAdmin(nombre,nombreUsuario,apellido1,apellido2,correo,contrasenna,imagen);

    }

    private void listarUsuarios() {
        for (UsuarioFinal ususario : gestor.listaRUsuarios()
        ) {
            interfaz.imprimirMensaje(ususario.toCSVLine());

        }
    }

    public void registrarArtista(String nombre, String apellido1, String nombreArtistico, String paisNacimiento,  String descripcion, LocalDate fechaNacimiento, LocalDate fechaDefuncion) {
        /*
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
*/
        int edad = Period.between(fechaNacimiento,LocalDate.now()).getYears();
        gestor.registroArtistas(nombre,apellido1,nombreArtistico,paisNacimiento,edad,descripcion,fechaNacimiento,fechaDefuncion);
        //interfaz.imprimirMensaje("Artista registrado");

    }

    private void listarArtistas() {
        for (Artista artista : gestor.listarArtistas()
        ) {
            interfaz.imprimirMensaje(artista.toCSVLine());
        }
    }



    public void registrarGenero(String nombre, String descripcion) {
        /*interfaz.imprimirMensaje("Nombre: ");
        String nombre = interfaz.leerTexto();
        interfaz.imprimirMensaje("Descripción: ");
        String descripcion = interfaz.leerTexto();*/
        gestor.guardarGenero(nombre,descripcion);
        //interfaz.imprimirMensaje("Genero musical resitrado con exito");
    }

    private void listarGeneros() {
        for (Genero genero : gestor.listaGeneros()
        ) {
            interfaz.imprimirMensaje(genero.toCSVLine());
        }
    }

    public void registrarCompositor(String nombre, String apellido1,  int edad, String paisNacimiento, String generocbx) {
        /*
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

         */
        Genero genero = gestor.encontrarGenero(generocbx);
        System.out.println(genero.getId());
        System.out.println(genero.toString());
        gestor.registroCompositor(nombre,apellido1,edad,paisNacimiento,genero);
    }

    private void listarCompositores() {
        for (Compositor comp : gestor.listarCompositores()
        ) {
            interfaz.imprimirMensaje(comp.toCSVLine());

        }
    }

    public void registrarCancion(String nombre, String mp3,LocalDate fechaLanzamiento, String Nombregenero, String Nombrecompositor,String Nombreartista, String Nombrealbum) {
        /*
        interfaz.imprimirMensaje("Nombre de la canción: ");
        String nombreCancion = interfaz.leerTexto();
        interfaz.imprimirMensaje("Fecha lanzamiento: ");
        String fecha = interfaz.leerTexto();
        interfaz.imprimirMensaje("Ingrese la cancion-->");
        //en estos momentos se esta probando con un string como link de la cancion
        String mp3 = interfaz.leerTexto();
        LocalDate fechaLanzamiento = obtenerFecha(fecha);*/
        Genero genero = gestor.encontrarGenero(Nombregenero);
        Compositor compositor = gestor.encontrarCompositorporNombre(Nombrecompositor);
        Artista artista = gestor.encontrarArtistaporNombre(Nombreartista);
        Album album = gestor.encontrarAlbum(Nombrealbum);
        gestor.guardarCancion(nombre,mp3,fechaLanzamiento,genero,compositor,artista,album);



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

    public void crearAlbum(String nombre, LocalDate fechalanzamiento, String imagen, String mp3) {
        /*
        interfaz.imprimirMensaje("Nombre del album: ");
        String nombreAlbum = interfaz.leerTexto();
        interfaz.imprimirMensaje("Fecha de lanzamiento: ");
        String fecha = interfaz.leerTexto();
        LocalDate fechaLanzamiento = obtenerFecha(fecha);
        interfaz.imprimirMensaje("Imagen del album: ");
        //De momento la imagen se maneja escribiendo un String
        String imagenAlbum = interfaz.leerTexto();*/
        gestor.guardarAlbum(nombre,fechalanzamiento,imagen,mp3);


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
