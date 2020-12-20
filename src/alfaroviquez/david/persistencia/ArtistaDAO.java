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
            this.cmdInsertar = con.prepareStatement(Template_Insertar,Statement.RETURN_GENERATED_KEYS);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int registrarArtista(Artista artista) throws SQLException {
        int indiceArtista = 0;
        if(this.cmdInsertar!=null){
            this.cmdInsertar.setString(1,artista.getNombre());
            this.cmdInsertar.setString(2,artista.getApellido1());
            this.cmdInsertar.setString(3,artista.getNombreArtistico());
            this.cmdInsertar.setString(4,artista.getPaisNacimiento());
            this.cmdInsertar.setDate(5, Date.valueOf(artista.getFechaNacimiento()));
            this.cmdInsertar.setDate(6,Date.valueOf(artista.getFechaDefuncion()==null ? null:artista.getFechaDefuncion()));
            this.cmdInsertar.setInt(7,artista.getEdad());
            this.cmdInsertar.setString(8,artista.getDescripcion());
            this.cmdInsertar.execute();
            ResultSet rs = cmdInsertar.getGeneratedKeys();
            while (rs.next()){
                indiceArtista = rs.getInt(1);
            }

        }
        return indiceArtista;

    }



    public List<Artista>encontrarArtista(){
        ArrayList<Artista> resultadosBD = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("Select * from artista");
            while(results.next()){
                Artista unArtista = new Artista();
                unArtista.setId(results.getInt("idArtista"));
                unArtista.setNombre(results.getString("nombreArtista"));
                unArtista.setApellido1(results.getString("apellido1"));
                unArtista.setNombreArtistico(results.getString("nombreArtistico"));
                unArtista.setPaisNacimiento(results.getString("pais"));
                unArtista.setFechaNacimiento(results.getDate("fechaNacimiento").toLocalDate());
               // unArtista.setFechaDefuncion(results.getDate("fechaDefuncion").toLocalDate());
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
