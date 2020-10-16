package alfaroviquez.david.bl.entidades;

public class Cancion {
    private  String nombre;
    private Genero genero;
    private Artista artista;
    private Compositor compositor;
    private String album;
    private String fechaLanzamiento;
    private  int calificacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Compositor getCompositor() {
        return compositor;
    }

    public void setCompositor(Compositor compositor) {
        this.compositor = compositor;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Cancion() {
    }

    public Cancion(String nombre, Genero genero, Artista artista, Compositor compositor, String album, String fechaLanzamiento, int calificacion) {
        this.nombre = nombre;
        this.genero = genero;
        this.artista = artista;
        this.compositor = compositor;
        this.album = album;
        this.fechaLanzamiento = fechaLanzamiento;
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "nombre='" + nombre + '\'' +
                ", genero=" + genero +
                ", artista=" + artista +
                ", compositor=" + compositor +
                ", album='" + album + '\'' +
                ", fechaLanzamiento='" + fechaLanzamiento + '\'' +
                ", calificacion=" + calificacion +
                '}';
    }
}
