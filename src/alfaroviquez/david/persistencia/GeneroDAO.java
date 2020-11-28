package alfaroviquez.david.persistencia;

import alfaroviquez.david.bl.entidades.Genero;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {

    Connection con;

    public GeneroDAO(Connection con){
        this.con=con;
    }

    public void registrarGenero(Genero genero){
        try{
            Statement statement = con.createStatement();
            StringBuilder sentence = new StringBuilder("insert into genero(nombreGenero,descripcion)");
            sentence.append("values ('");
            sentence.append(genero.getNombre());
            sentence.append("','");
            sentence.append(genero.getDescripcion());
            sentence.append("')");
            statement.execute(sentence.toString());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Genero> encontrarGeneros(){
        ArrayList<Genero> listadeGenerosBD = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("Select * from genero");
            while(results.next()){
                Genero unGenero = new Genero();
                unGenero.setNombre(results.getString("nombreGenero"));
                unGenero.setDescripcion(results.getString("descripcion"));
                listadeGenerosBD.add(unGenero);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return listadeGenerosBD;
    }
}
