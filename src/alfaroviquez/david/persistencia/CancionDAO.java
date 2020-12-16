package alfaroviquez.david.persistencia;

import alfaroviquez.david.bl.entidades.Cancion;
import alfaroviquez.david.bl.logica.Gestor;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CancionDAO {

    Connection con;
    private final String TEMPLATE_INSETAR = "insert into cancion (nombreCancion,mp3,fechaLanzamiento,idGenero,idCompositor,idArtista,idAlbum)" +
            "values(?,?,?,?,?,?,?)";
    private final String TEMPLATE_CONSULTA = "select * from cancion";
    private PreparedStatement cmdInsertar;
    private PreparedStatement cmdConsulta;

    public CancionDAO(Connection con) {
        this.con = con;
        try {
            this.cmdConsulta = con.prepareStatement(TEMPLATE_CONSULTA);
            this.cmdInsertar = con.prepareStatement(TEMPLATE_INSETAR, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int registrarCancion(Cancion cancion) throws SQLException {
        int indiceCancion = 0;
        if (this.cmdInsertar != null) {
            this.cmdInsertar.setString(1, cancion.getNombre());
            this.cmdInsertar.setString(2, cancion.getMp3());
            this.cmdInsertar.setDate(3, Date.valueOf(cancion.getFechaLanzamiento()));
            this.cmdInsertar.setInt(4, cancion.getGenero().getId());
            this.cmdInsertar.setInt(5, cancion.getCompositor().getId());
            this.cmdInsertar.setInt(6, cancion.getArtista().getId());
            this.cmdInsertar.setInt(7, cancion.getAlbum().getId());
            this.cmdInsertar.execute();
            ResultSet rs = this.cmdInsertar.getGeneratedKeys();
            while (rs.next()) {
                indiceCancion = rs.getInt(1);
            }

        }
        return indiceCancion;
    }




    public List<Cancion> encontrarCanciones() {
        ArrayList<Cancion> listaCanciones = new ArrayList<>();
        try {
            ResultSet rs = this.cmdConsulta.executeQuery();
            while (rs.next()) {
                Cancion cancion = new Cancion();
                cancion.setId(rs.getInt("idCancion"));
                cancion.setNombre(rs.getString("nombreCancion"));
                cancion.setMp3(rs.getString("mp3"));
                cancion.setFechaLanzamiento(rs.getDate("fechaLanzamiento").toLocalDate());
                //cancion.setGenero(gestor.encontrarGeneroPorId(rs.getInt("idGenero")));
                //cancion.setCompositor(gestor.encontrarCompositorporId(rs.getInt("idCompositor")));
                //cancion.setArtista(gestor.encontrarArtistaporId(rs.getInt("idArtista")));
                //cancion.setAlbum(gestor.encontrarAlbumporId(rs.getInt("idAlbum")));
                listaCanciones.add(cancion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCanciones;
    }
}
