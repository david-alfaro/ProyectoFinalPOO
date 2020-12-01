package alfaroviquez.david.persistencia;

import alfaroviquez.david.bl.entidades.Cancion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CancionDAO {

    Connection con;

    public CancionDAO(Connection con){
        this.con=con;
    }

    public void registrarCancion(Cancion cancion){
        try{
            Statement statement = con.createStatement();
            StringBuilder query = new StringBuilder("insert into cancion (nombreCancion,mp3,fechaLanzamiento)");
            query.append("values('");
            query.append(cancion.getNombre());
            query.append("','");
            query.append(cancion.getMp3());
            query.append("','");
            query.append(cancion.getFechaLanzamiento());
            query.append("')");
            statement.execute(query.toString());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Cancion> encontrarCanciones(){
        ArrayList<Cancion> resultadosBD = new ArrayList<>();
        try{
            Statement query = con.createStatement();
            ResultSet resultSet = query.executeQuery("Select * from cancion");
            while (resultSet.next()){
                Cancion unaCancion = new Cancion();
                unaCancion.setNombre(resultSet.getString("nombreCancion"));
                unaCancion.setMp3(resultSet.getString("mp3"));
                unaCancion.setFechaLanzamiento(LocalDate.parse(resultSet.getString("fechaLanzamiento")));
                resultadosBD.add(unaCancion);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultadosBD;
    }
}
