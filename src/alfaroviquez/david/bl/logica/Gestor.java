package alfaroviquez.david.bl.logica;

import alfaroviquez.david.bl.entidades.*;
import alfaroviquez.david.persistencia.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    private AdministrativoDAO repoAdminDAO;
    private UsuarioFinalDAO repositorioUsuariosDB;
    private CompositorDAO repositorioCompositoresDB;
    private ArtistaDAO repositorioArtistasDB;
    private GeneroDAO repositorioGeneroBD;
    private CancionDAO repositiorCancionesBD;
    private AlbumDAO repositorioAlbumBD;

    private AlbumXCancionDAO repoAlbumXCancionBD;

    public Gestor() {


        this.artistas = new ArrayList<>();
        this.generos = new ArrayList<>();
        this.canciones = new ArrayList<>();
        this.listasDeReproduccion = new ArrayList<>();
        this.albums = new ArrayList<>();


        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, USER, PWD);
            this.repoAdminDAO = new AdministrativoDAO(this.connection);
            this.repositorioUsuariosDB = new UsuarioFinalDAO(this.connection);
            this.repositorioCompositoresDB = new CompositorDAO(this.connection);
            this.repositorioArtistasDB = new ArtistaDAO(this.connection);
            this.repositorioGeneroBD = new GeneroDAO(this.connection);
            this.repositiorCancionesBD = new CancionDAO(this.connection);
            this.repositorioAlbumBD = new AlbumDAO(this.connection);
            this.repoAlbumXCancionBD = new AlbumXCancionDAO(this.connection);
        } catch (Exception e) {
            System.out.println("No se puede conectar a las BD");
            e.printStackTrace();
        }
    }

    public void registrarAdmin(String nombre, String nombreUsuario, String apellido1, String apellido2, String correo, String contrasenna, String imagen){
        Administrador nuevoAdmin = new Administrador( nombre, nombreUsuario,apellido1,  apellido2, correo, contrasenna, imagen);
        try {
            repoAdminDAO.guardarAdmin(nuevoAdmin);
        } catch (SQLException e) {
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

    public void registroCompositor(String nombre, String apellido1,  int edad, String paisNacimiento, Genero genero) {
        Compositor nuevoCompositor = new Compositor(nombre, apellido1, edad, paisNacimiento, genero);
        try {
            nuevoCompositor.setId(repositorioCompositoresDB.registrarCompositor(nuevoCompositor));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Compositor> listarCompositores() {
        return this.repositorioCompositoresDB.encontrarCompositores();
    }

    public void registroArtistas(String nombre, String apellido1, String nombreArtistico, String paisNacimiento, int edad, String descripcion, LocalDate fechaNacimiento, LocalDate fechaDefuncion)  {
        Artista nuevoArtista = new Artista(nombre, apellido1, nombreArtistico, paisNacimiento, edad, descripcion, fechaNacimiento, fechaDefuncion);
        try {
            nuevoArtista.setId(repositorioArtistasDB.registrarArtista(nuevoArtista));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public List<Artista> listarArtistas() {
        return this.repositorioArtistasDB.encontrarArtista();
    }


    public void guardarGenero(String nombre, String descripcion) {
        Genero nuevoGenero = new Genero(nombre, descripcion);
        try {
            nuevoGenero.setId(repositorioGeneroBD.registrarGenero(nuevoGenero));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(nuevoGenero.getId());
    }

    public List<Genero> listaGeneros() {
        return this.repositorioGeneroBD.encontrarGeneros();
    }


    //public ArrayList<Compositor> listaCompositores() {
    //return this.compositores;
    //}

    public void guardarCancion(String nombre, String mp3,LocalDate fechaLanzamiento, Genero genero, Compositor compositor,Artista artista, Album album ) {
        Cancion nuevaCancion = new Cancion(nombre,artista,genero,compositor,album,mp3,fechaLanzamiento);
        try {
            nuevaCancion.setId(repositiorCancionesBD.registrarCancion(nuevaCancion));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(nuevaCancion.getId());
    }

    public List<Cancion> listaCanciones() {

        return this.repositiorCancionesBD.encontrarCanciones();
    }


    public Compositor encontrarCompositorporId(int id) {
        List<Compositor> unCompositor = listarCompositores();
        for (int i = 0; i < unCompositor.size(); i++) {
            Compositor temp = unCompositor.get(i);
            if (temp.getId()==id) {
                return temp;
            }
        }
        return null;
    }
    public Compositor encontrarCompositorporNombre(String nombre) {
        List<Compositor> unCompositor = listarCompositores();
        for (int i = 0; i < unCompositor.size(); i++) {
            Compositor temp = unCompositor.get(i);
            if (temp.getNombre().equalsIgnoreCase(nombre)) {
                return temp;
            }
        }
        return null;
    }


    public Genero encontrarGenero(String nombre) {
        List<Genero>listaGeneros = listaGeneros();
        for (int i = 0; i < listaGeneros.size(); i++) {
            Genero temp = listaGeneros.get(i);
            if (temp.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
                return temp;
            }
        }
        return null;
    }

    public Genero encontrarGeneroPorId(int id){
        List<Genero>listaGeneros = listaGeneros();
        for (int i = 0; i < listaGeneros.size(); i++) {
            Genero temp = listaGeneros.get(i);
            if (temp.getId()==id) {
                return temp;
            }
        }
        return null;
    }

    public Artista encontrarArtistaporId(int id) {
        List<Artista> listaDEArtistas = listarArtistas();
        for (int i = 0; i < listaDEArtistas.size(); i++) {
            Artista temp = listaDEArtistas.get(i);
            if (temp.getId()==id) {
                return temp;
            }
        }
        return null;
    }
    public Artista encontrarArtistaporNombre(String nombre) {
        List<Artista> listaDEArtistas = listarArtistas();
        for (int i = 0; i < listaDEArtistas.size(); i++) {
            Artista temp = listaDEArtistas.get(i);
            if (temp.getNombre().equalsIgnoreCase(nombre)) {
                return temp;
            }
        }
        return null;
    }
    public Album encontrarAlbumporId(int id) {
        List<Album> listaDEAlbum = listarAlbums();
        for (int i = 0; i < listaDEAlbum.size(); i++) {
            Album temp = listaDEAlbum.get(i);
            if (temp.getId()==id) {
                return temp;
            }
        }
        return null;
    }
    public Album encontrarAlbumporNombre(String nombre) {
        List<Album> listaDEAlbum = listarAlbums();
        for (int i = 0; i < listaDEAlbum.size(); i++) {
            Album temp = listaDEAlbum.get(i);
            if (temp.getNombre().equalsIgnoreCase(nombre)) {
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
        List<Cancion> listaDECanciones = listaCanciones();
        for (int i = 0; i < listaDECanciones.size(); i++) {
            Cancion temp = listaDECanciones.get(i);
            if (temp.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
                return temp;
            }
        }
        return null;
    }
    public Album encontrarAlbum(String nombre){
        List<Album> listaDEAlbums = listarAlbums();
        for (int i = 0; i < listaDEAlbums.size(); i++) {
            Album temp = listaDEAlbums.get(i);
            if (temp.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
                return temp;
            }
        }
        return null;
    }

    public void guardarAlbum(String nombre, LocalDate fechalanzamiento, String imagen, String mp3) {
        Album nuevoAlbum = new Album(nombre,fechalanzamiento,imagen,mp3);
        try {
            nuevoAlbum.setId(repositorioAlbumBD.registrarAlbum(nuevoAlbum));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Album> listarAlbums() {

        return this.repositorioAlbumBD.listaDeAlbums();
    }

    public void agregarCancionaAlbum(String nombreCancion,String nombreAlbum) {
        Cancion unaCancion = encontrarCancion(nombreCancion);
        Album unAlbum = encontrarAlbum(nombreAlbum);
        repoAlbumXCancionBD.guardarAlbum(unAlbum,unaCancion);

    }




}
