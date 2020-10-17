package alfaroviquez.david.bl.logica;

import alfaroviquez.david.bl.entidades.*;

import java.util.ArrayList;

public class Gestor {


    private ArrayList<Usuario> usuarios;
    private ArrayList<Artista> artistas;
    private ArrayList<Genero> generos;
    private ArrayList<Compositor> compositores;
    private ArrayList<Cancion> canciones;
    private ArrayList<ListaReproduccion> listasDeReproduccion;
    private ArrayList<Album> albums;

    public Gestor() {

        this.usuarios = new ArrayList<>();
        this.artistas = new ArrayList<>();
        this.generos = new ArrayList<>();
        this.compositores = new ArrayList<>();
        this.canciones = new ArrayList<>();
        this.listasDeReproduccion = new ArrayList<>();
        this.albums = new ArrayList<>();
    }


    public void guardarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public ArrayList<Usuario> listaUsuarios() {
        return this.usuarios;
    }

    public void guardarArtista(Artista artista){
        artistas.add(artista);
    }
     public ArrayList<Artista> listarArtistas(){
        return this.artistas;
     }
     public void guardarGenero(Genero genero){
        generos.add(genero);
     }
     public ArrayList<Genero> listaGeneros(){
        return this.generos;
     }
     public void guardarCompositor(Compositor compositor){
        compositores.add(compositor);
     }
     public ArrayList<Compositor> listaCompositores(){
        return this.compositores;
     }
     public void guardarCancion(Cancion cancion){
        canciones.add(cancion);
     }
     public ArrayList<Cancion> listaCanciones(){
        return this.canciones;
     }
     public Compositor encontrarCompositor(String nombre){
        for(int i=0;i<compositores.size();i++){
            Compositor temp = compositores.get(i);
            if(temp.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                return temp;
            }
        }
        return null;
     }
     public Genero encontrarGenero(String nombre){
        for(int i=0; i<generos.size();i++){
            Genero temp = generos.get(i);
            if(temp.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                return temp;
            }
        }
        return null;
     }
     public Artista encontrarArtista(String nombre){
        for(int i=0;i<artistas.size();i++){
            Artista temp = artistas.get(i);
            if(temp.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                return temp;
            }
        }
        return null;
     }
     public void guardarLista(ListaReproduccion listaReproduccion){
        listasDeReproduccion.add(listaReproduccion);
     }

     public ArrayList<ListaReproduccion> listarListasReproduccion(){
        return this.listasDeReproduccion;
     }

     public void agregarCancion(String nombreLista, Cancion cancion){
        for(int i=0; i<listasDeReproduccion.size();i++){
            ListaReproduccion listaActual = listasDeReproduccion.get(i);
            if(listaActual.getNombre().toLowerCase().equals(nombreLista.toLowerCase())){
                listaActual.getCanciones().add(cancion);
            }
        }
     }

     public Cancion encontrarCancion(String nombre){
        for(int i=0; i<canciones.size();i++){
            Cancion temp = canciones.get(i);
            if(temp.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                return temp;
            }
        }
        return null;
     }

     public void guardarAlbum(Album album){
        albums.add(album);
     }

     public ArrayList<Album> listarAlbums(){
        return this.albums;
     }

     public void agregarCancionaAlbum(String nombreAlbum, Cancion cancion){
        for(int i=0;i<albums.size();i++){
            Album albumActual = albums.get(i);
            if(albumActual.getNombre().toLowerCase().equals(nombreAlbum.toLowerCase())){
                albumActual.getCanciones().add(cancion);
            }
        }
     }
     public void agregarArtista(String nombre, Artista artista){
        for(int i=0;i<albums.size();i++){
            Album albumActual = albums.get(i);
            if(albumActual.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                albumActual.getArtistas().add(artista);
            }
        }
     }
    public float puntajeLista(ListaReproduccion lista){
        float prom = 0;
        for(int i=0; i<lista.getCanciones().size();i++){
            Cancion cancion = lista.getCanciones().get(i);
            int calificacion = cancion.getCalificacion();
            int sumaCal = 0;
            sumaCal = calificacion+sumaCal;
            prom = sumaCal/lista.getCanciones().size();
        }
        return prom;
    }
}
