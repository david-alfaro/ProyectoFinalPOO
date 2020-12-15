package alfaroviquez.david.persistencia;

import alfaroviquez.david.bl.entidades.Album;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {
    Connection con;

    private final String TEMPLATE_INSETAR = "insert into album (nombreAlbum,imagenAlbum,fechaLanzamiento,mp3file)" +
            "values(?,?,?,?)";
    private PreparedStatement cmInsertar;

    public AlbumDAO(Connection cnx){
        this.con=cnx;
        try{
            this.cmInsertar=con.prepareStatement(TEMPLATE_INSETAR,Statement.RETURN_GENERATED_KEYS);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int registrarAlbum(Album album) throws SQLException {
        int indiceAlbum = 0;
        if(this.cmInsertar!=null){
            this.cmInsertar.setString(1,album.getNombre());
            this.cmInsertar.setString(2,album.getImagen());
            this.cmInsertar.setDate(3, Date.valueOf(album.getFechalanzamiento()));
            this.cmInsertar.setString(4, String.valueOf(album.getCanciones()));
            this.cmInsertar.execute();
            ResultSet rs = cmInsertar.getGeneratedKeys();
            while(rs.next()){
                indiceAlbum=rs.getInt(1);
            }
        }
        return indiceAlbum;
    }

    public List<Album> listaDeAlbums(){
        ArrayList<Album> resultadosBD = new ArrayList<>();
        try{
            Statement query = con.createStatement();
            ResultSet resultSet = query.executeQuery("Select * from album");
            while (resultSet.next()){
                Album unAlbum = new Album();
                unAlbum.setId(resultSet.getInt("idAlbum"));
                unAlbum.setNombre(resultSet.getString("nombreAlbum"));
                unAlbum.setImagen(resultSet.getString("imagenAlbum"));
                unAlbum.setFechalanzamiento(LocalDate.parse(resultSet.getString("fechaLanzamiento")));
                unAlbum.setCanciones(resultSet.getString("mp3file"));
                resultadosBD.add(unAlbum);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultadosBD;
    }
}
