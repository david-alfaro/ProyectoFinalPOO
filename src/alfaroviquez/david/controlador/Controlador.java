package alfaroviquez.david.controlador;

import alfaroviquez.david.bl.entidades.*;
import alfaroviquez.david.bl.logica.Gestor;
import alfaroviquez.david.iu.IU;

import java.util.ArrayList;

public class Controlador {
    private IU interfaz = new IU();
    private Gestor gestor = new Gestor();

    public void ejecutarPrograma() {
        int opcion = 0;
        do {
            interfaz.menu();
            opcion = interfaz.leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 14);
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
                break;

            default:
                interfaz.imprimirMensaje("Opcion invalida");
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
        interfaz.imprimirMensaje("Contrasena: ");
        String contrasenna = interfaz.leerTexto();
        interfaz.imprimirMensaje("Imagen de perfil o avatar: ");
        String imagen = interfaz.leerTexto();
        interfaz.imprimirMensaje("Edad: ");
        int edad = interfaz.leerNumeros();
        interfaz.imprimirMensaje("Pais de origen: ");
        String pais = interfaz.leerTexto();
        interfaz.imprimirMensaje("Identificacion: ");
        String identificacion = interfaz.leerTexto();
        if (edad >= 18) {
            UsuarioFinal nuevoUsuario = new UsuarioFinal(nombre, apellido1, apellido2, nombreUsuario, correo, contrasenna, imagen, edad, pais, identificacion);
            gestor.guardarUsuario(nuevoUsuario);
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
        interfaz.imprimirMensaje("Contrasena: ");
        String contrasenna = interfaz.leerTexto();
        interfaz.imprimirMensaje("Imagen de perfil o avatar: ");
        String imagen = interfaz.leerTexto();
        Administrador admin = new Administrador(nombre, apellido1, apellido2, nombreUsuario, correo, contrasenna, imagen);
        gestor.guardarUsuario(admin);
    }

    private void listarUsuarios() {
        for (Usuario u : gestor.listaUsuarios()
        ) {
            interfaz.imprimirMensaje(u.toString());

        }
    }

    private void registrarArtista() {
        interfaz.imprimirMensaje("Nombre: ");
        String nombre = interfaz.leerTexto();
        interfaz.imprimirMensaje("Primer apellido: ");
        String apellido1 = interfaz.leerTexto();
        interfaz.imprimirMensaje("Segundo apellido: ");
        String apellido2 = interfaz.leerTexto();
        interfaz.imprimirMensaje("Nombre artistico: ");
        String nombreArtistico = interfaz.leerTexto();
        interfaz.imprimirMensaje("Pais de origen: ");
        String pais = interfaz.leerTexto();
        interfaz.imprimirMensaje("Genero: ");
        String genero = interfaz.leerTexto();
        interfaz.imprimirMensaje("Edad: ");
        int edad = interfaz.leerNumeros();
        interfaz.imprimirMensaje("Descripcion: ");
        String descripcion = interfaz.leerTexto();
        interfaz.imprimirMensaje("Fecha de nacimiento: ");
        String fechaNacimiento = interfaz.leerTexto();
        interfaz.imprimirMensaje("Fecha de defuncion: ");
        String fechaDefuncion = interfaz.leerTexto();
        Artista nuevoArtista = new Artista(nombre, apellido1, apellido2, nombreArtistico, pais, genero, edad, descripcion, fechaNacimiento, fechaDefuncion);
        gestor.guardarArtista(nuevoArtista);
    }

    private void listarArtistas() {
        for (Artista artista : gestor.listarArtistas()
        ) {
            interfaz.imprimirMensaje(artista.toString());
        }
    }

    private void registrarGenero() {
        interfaz.imprimirMensaje("Nombre: ");
        String nombre = interfaz.leerTexto();
        interfaz.imprimirMensaje("Descripcion: ");
        String descripcion = interfaz.leerTexto();
        Genero nuevoGenero = new Genero(nombre, descripcion);
        gestor.guardarGenero(nuevoGenero);
    }

    private void listarGeneros() {
        for (Genero genero : gestor.listaGeneros()
        ) {
            interfaz.imprimirMensaje(genero.toString());
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
        Compositor nuevoCompositor = new Compositor(nombre, apellido1, apellido2, edad, pais);
        gestor.guardarCompositor(nuevoCompositor);
    }

    private void listarCompositores() {
        for (Compositor comp : gestor.listaCompositores()
        ) {
            interfaz.imprimirMensaje(comp.toString());

        }
    }

    private void registrarCancion() {
        interfaz.imprimirMensaje("Nombre de la cancion: ");
        String nombreCancion = interfaz.leerTexto();
        interfaz.imprimirMensaje("Nombre del genero: ");
        String nombreGenero = interfaz.leerTexto();
        Genero unGenero = gestor.encontrarGenero(nombreGenero);
        interfaz.imprimirMensaje("Nombre del artista: ");
        String nombreArtista = interfaz.leerTexto();
        Artista unArtista = gestor.encontrarArtista(nombreArtista);
        interfaz.imprimirMensaje("Nombre compositor: ");
        String nombreCompositor = interfaz.leerTexto();
        Compositor unCompositor = gestor.encontrarCompositor(nombreCompositor);
        interfaz.imprimirMensaje("Nombre del album: ");
        String nombreAlbum = interfaz.leerTexto();
        interfaz.imprimirMensaje("Fecha lanzamiento: ");
        String fecha = interfaz.leerTexto();
        interfaz.imprimirMensaje("Calificacion: ");
        int calificacion = interfaz.leerNumeros();
        Cancion nuevaCancion = new Cancion(nombreCancion, unGenero, unArtista, unCompositor, nombreAlbum, fecha, calificacion);
        gestor.guardarCancion(nuevaCancion);
        interfaz.imprimirMensaje("Cancion creada!");


    }

    public void listarCanciones() {
        interfaz.imprimirMensaje("Lista de canciones --> ");
        for (Cancion cancion : gestor.listaCanciones()
        ) {
            interfaz.imprimirMensaje(cancion.toString());
        }
    }

    public void crearListaReproduccion() {
        interfaz.imprimirMensaje("Nombre: ");
        String nombreLista = interfaz.leerTexto();
        interfaz.imprimirMensaje("Fecha de creacion: ");
        String fecha = interfaz.leerTexto();
        ListaReproduccion nuevaLista = new ListaReproduccion();
        nuevaLista.setNombre(nombreLista);
        nuevaLista.setFechaCreacion(fecha);
        interfaz.imprimirMensaje("Nombre de cancion: ");
        String nombreCancion = interfaz.leerTexto();
        Cancion unaCancion = gestor.encontrarCancion(nombreCancion);
        gestor.agregarCancion(nombreLista, unaCancion);


    }

    public void listarListaReproduccion() {
        for (ListaReproduccion repro : gestor.listarListasReproduccion()
        ) {
            interfaz.imprimirMensaje(repro.toString());
        }
    }


}
