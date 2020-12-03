package alfaroviquez.david.persistencia;

import alfaroviquez.david.bl.entidades.Album;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {
    Connection con;

    public AlbumDAO(Connection cnx){
        this.con=cnx;
    }

    public int registrarAlbum(Album album){
        int indicealbum = -1;
        try{
            Statement statement = con.createStatement();
            StringBuilder query = new StringBuilder("insert into album (nombreAlbum,imagenAlbum,fechaLanzamiento)");
            query.append("values ('");
            query.append(album.getNombre());
            query.append("','");
            query.append(album.getImagen());
            query.append("','");
            query.append(album.getFechalanzamiento());
            query.append("')");
            statement.execute(query.toString(), statement.RETURN_GENERATED_KEYS);
            ResultSet getGeneratedKeys = statement.getGeneratedKeys();
            while (getGeneratedKeys.next()){
                indicealbum = getGeneratedKeys.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return indicealbum;
    }

    public List<Album> listaDeAlbums(){
        ArrayList<Album> resultadosBD = new ArrayList<>();
        try{
            Statement query = con.createStatement();
            ResultSet resultSet = query.executeQuery("Select * from album");
            while (resultSet.next()){
                Album unAlbum = new Album();
                unAlbum.setNombre(resultSet.getString("nombreAlbum"));
                unAlbum.setImagen(resultSet.getString("imagenAlbum"));
                unAlbum.setFechalanzamiento(LocalDate.parse(resultSet.getString("fechaLanzamiento")));
                resultadosBD.add(unAlbum);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultadosBD;
    }
}
