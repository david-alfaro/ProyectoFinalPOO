package alfaroviquez.david.persistencia;

import alfaroviquez.david.bl.entidades.Artista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArtistaDAO {

    Connection con;

    public ArtistaDAO(Connection con){
        this.con = con;
    }

    public void registrarArtista(Artista artista){
        try{
            Statement statement = con.createStatement();
            StringBuilder sentence = new StringBuilder("insert into artista (nombreArtista,apellido1,nombreArtistico,pais,fechaNacimiento,fechaDefuncion,edad,descripcion)");
            sentence.append("values ('");
            sentence.append(artista.getNombre());
            sentence.append("','");
            sentence.append(artista.getApellido1());
            sentence.append("','");
            sentence.append(artista.getNombreArtistico());
            sentence.append("','");
            sentence.append(artista.getPaisNacimiento());
            sentence.append("','");
            sentence.append(artista.getFechaNacimiento());
            sentence.append("','");
            sentence.append(artista.getFechaDefuncion());
            sentence.append("',");
            sentence.append(artista.getEdad());
            sentence.append(",'");
            sentence.append(artista.getDescripcion());
            sentence.append("')");
            statement.execute(sentence.toString());
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    public List<Artista>encontrarArtista(){
        ArrayList<Artista> resultadosBD = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("Select * from artista");
            while(results.next()){
                Artista unArtista = new Artista();
                unArtista.setNombre(results.getString("nombreArtista"));
                unArtista.setApellido1(results.getString("apellido1"));
                unArtista.setNombreArtistico(results.getString("nombreArtistico"));
                unArtista.setPaisNacimiento(results.getString("pais"));
                unArtista.setFechaNacimiento(LocalDate.parse(results.getString("fechaNacimiento")));
                unArtista.setFechaDefuncion(LocalDate.parse(results.getString("fechaDefuncion")));
                unArtista.setEdad(results.getInt("edad"));
                unArtista.setDescripcion(results.getString("descripcion"));
                resultadosBD.add(unArtista);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return resultadosBD;
    }
}
