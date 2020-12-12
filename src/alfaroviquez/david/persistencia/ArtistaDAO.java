package alfaroviquez.david.persistencia;

import alfaroviquez.david.bl.entidades.Artista;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArtistaDAO {

    Connection con;
    private final String Template_Insertar = "insert into artista (nombreArtista,apellido1,nombreArtistico,pais,fechaNacimiento,fechaDefuncion,edad,descripcion)" +
            "values (?,?,?,?,?,?,?,?)";

    private PreparedStatement cmdInsertar;

    public ArtistaDAO(Connection con){

        this.con = con;
        try{
            this.cmdInsertar = con.prepareStatement(Template_Insertar);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void registrarArtista(Artista artista) throws SQLException {
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(this.cmdInsertar!=null){
            this.cmdInsertar.setString(1,artista.getNombre());
            this.cmdInsertar.setString(2,artista.getApellido1());
            this.cmdInsertar.setString(3,artista.getNombreArtistico());
            this.cmdInsertar.setString(4,artista.getPaisNacimiento());
            this.cmdInsertar.setDate(5, Date.valueOf(artista.getFechaNacimiento()));
            this.cmdInsertar.setString(6,artista.getFechaDefuncion()==null ? null:"'"+artista.getFechaDefuncion()+"'");
            this.cmdInsertar.setInt(7,artista.getEdad());
            this.cmdInsertar.setString(8,artista.getDescripcion());
            this.cmdInsertar.execute();

        }
        /*
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
            sentence.append("',");
            sentence.append(artista.getFechaDefuncion()==null ? null:"'"+artista.getFechaDefuncion()+"'");
            sentence.append(",");
            sentence.append(artista.getEdad());
            sentence.append(",'");
            sentence.append(artista.getDescripcion());
            sentence.append("')");
            statement.execute(sentence.toString());
        }catch (SQLException e){
            e.printStackTrace();
        }*/


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
