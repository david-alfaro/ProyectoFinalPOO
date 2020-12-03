package alfaroviquez.david.bl.entidades;

public class AlbumXCancion {
    private int id;
    private Cancion cancion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public AlbumXCancion() {
    }

    public AlbumXCancion(int id, Cancion cancion) {
        this.id = id;
        this.cancion = cancion;
    }

    @Override
    public String toString() {
        return "AlbumXCancion{" +
                "id=" + id +
                ", cancion=" + cancion +
                '}';
    }
}
