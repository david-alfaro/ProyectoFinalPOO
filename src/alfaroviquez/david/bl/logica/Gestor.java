package alfaroviquez.david.bl.logica;

import alfaroviquez.david.bl.entidades.*;
import alfaroviquez.david.persistencia.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gestor {


    private ArrayList<Artista> artistas;
    private ArrayList<Genero> generos;
    private ArrayList<Cancion> canciones;
    private ArrayList<ListaReproduccion> listasDeReproduccion;
    private ArrayList<Album> albums;

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/musicapp";
    private final String USER = "root";
    private final String PWD = "12345";
    private Connection connection;

    private UsuarioFinalDAO repositorioUsuariosDB;
    private CompositorDAO repositorioCompositoresDB;
    private ArtistaDAO repositorioArtistasDB;
    private GeneroDAO repositorioGeneroBD;
    private CancionDAO repositiorCancionesBD;

    public Gestor() {


        this.artistas = new ArrayList<>();
        this.generos = new ArrayList<>();
        this.canciones = new ArrayList<>();
        this.listasDeReproduccion = new ArrayList<>();
        this.albums = new ArrayList<>();


        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, USER, PWD);
            this.repositorioUsuariosDB = new UsuarioFinalDAO(this.connection);
            this.repositorioCompositoresDB = new CompositorDAO(this.connection);
            this.repositorioArtistasDB = new ArtistaDAO(this.connection);
            this.repositorioGeneroBD = new GeneroDAO(this.connection);
            this.repositiorCancionesBD = new CancionDAO(this.connection);
        } catch (Exception e) {
            System.out.println("No se puede conectar a las BD");
            e.printStackTrace();
        }
    }

    public void registroUsuario(String nombre, String apellido1, String apellido2, String nombreUsuario, String correo, String contrasenna, String imagen, int edad, String pais, String identificacion) {
        UsuarioFinal nuevoUsuario = new UsuarioFinal(nombre, apellido1, apellido2, nombreUsuario, correo, contrasenna, imagen, edad, pais, identificacion);
        repositorioUsuariosDB.resgitrarUsuario(nuevoUsuario);
    }

    public List<UsuarioFinal> listaRUsuarios() {
        return this.repositorioUsuariosDB.listarUsuarios();
    }

    public void registroCompositor(String nombre, String apellido1, String apellido2, int edad, String paisNacimiento) {
        Compositor nuevoCompositor = new Compositor(nombre, apellido1, apellido2, edad, paisNacimiento);
        repositorioCompositoresDB.registrarCompositor(nuevoCompositor);

    }

    public List<Compositor> listarCompositores() {
        return this.repositorioCompositoresDB.encontrarCompositores();
    }

    public void registroArtistas(String nombre, String apellido1, String nombreArtistico, String paisNacimiento, int edad, String descripcion, LocalDate fechaNacimiento, LocalDate fechaDefuncion) {
        Artista nuevoArtista = new Artista(nombre, apellido1, nombreArtistico, paisNacimiento, edad, descripcion, fechaNacimiento, fechaDefuncion);
        repositorioArtistasDB.registrarArtista(nuevoArtista);

    }

    public List<Artista> listarArtistas() {
        return this.repositorioArtistasDB.encontrarArtista();
    }


    public void guardarGenero(String nombre, String descripcion) {
        Genero nuevoGenero = new Genero(nombre, descripcion);
        repositorioGeneroBD.registrarGenero(nuevoGenero);
    }

    public List<Genero> listaGeneros() {
        return this.repositorioGeneroBD.encontrarGeneros();
    }


    //public ArrayList<Compositor> listaCompositores() {
    //return this.compositores;
    //}

    public void guardarCancion(String nombre, String mp3, LocalDate fechaLanzamiento) {
        Cancion nuevaCancion = new Cancion(nombre,mp3,fechaLanzamiento);
        repositiorCancionesBD.registrarCancion(nuevaCancion);
    }

    public List<Cancion> listaCanciones() {

        return this.repositiorCancionesBD.encontrarCanciones();
    }


    public Compositor encontrarCompositor(String nombre) {
        List<Compositor> unCompositor = listarCompositores();
        for (int i = 0; i < unCompositor.size(); i++) {
            Compositor temp = unCompositor.get(i);
            if (temp.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
                return temp;
            }
        }
        return null;
    }


    public Genero encontrarGenero(String nombre) {
        for (int i = 0; i < generos.size(); i++) {
            Genero temp = generos.get(i);
            if (temp.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
                return temp;
            }
        }
        return null;
    }

    public Artista encontrarArtista(String nombre) {
        for (int i = 0; i < artistas.size(); i++) {
            Artista temp = artistas.get(i);
            if (temp.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
                return temp;
            }
        }
        return null;
    }

    public void guardarLista(ListaReproduccion listaReproduccion) {
        listasDeReproduccion.add(listaReproduccion);
    }

    public ArrayList<ListaReproduccion> listarListasReproduccion() {
        return this.listasDeReproduccion;
    }

    public void agregarCancion(String nombreLista, Cancion cancion) {
        for (int i = 0; i < listasDeReproduccion.size(); i++) {
            ListaReproduccion listaActual = listasDeReproduccion.get(i);
            if (listaActual.getNombre().toLowerCase().equals(nombreLista.toLowerCase())) {
                listaActual.getCanciones().add(cancion);
            }
        }
    }

    public Cancion encontrarCancion(String nombre) {
        for (int i = 0; i < canciones.size(); i++) {
            Cancion temp = canciones.get(i);
            if (temp.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
                return temp;
            }
        }
        return null;
    }

    public void guardarAlbum(Album album) {
        albums.add(album);
    }

    public ArrayList<Album> listarAlbums() {
        return this.albums;
    }

    public void agregarCancionaAlbum(String nombreAlbum, Cancion cancion) {
        for (int i = 0; i < albums.size(); i++) {
            Album albumActual = albums.get(i);
            if (albumActual.getNombre().toLowerCase().equals(nombreAlbum.toLowerCase())) {
                albumActual.getCanciones().add(cancion);
            }
        }
    }

    


}
