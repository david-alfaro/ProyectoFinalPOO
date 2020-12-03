package alfaroviquez.david.persistencia;

import alfaroviquez.david.bl.entidades.Album;
import alfaroviquez.david.bl.entidades.Cancion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumXCancionDAO {

    Connection con;

    public AlbumXCancionDAO(Connection con){
        this.con=con;
    }

    public void guardarAlbum(Album album, Cancion cancion){
        try {
            Statement statement = con.createStatement();
            StringBuilder query = new StringBuilder("insert into albumXcancion (idAlbum,idCancion) ");
            query.append("values (");
            query.append(album.getId());
            query.append(",");
            query.append(cancion.getId());
            query.append(")");
            statement.execute(query.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
