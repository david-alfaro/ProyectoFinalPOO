package alfaroviquez.david.persistencia;

import alfaroviquez.david.bl.entidades.Genero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {

    Connection con;
    private final String TEMPLATE_INSERTAR = "insert into genero(nombreGenero,descripcion)" +
            "values(?,?)";
    private PreparedStatement cmdInsertar;
    public GeneroDAO(Connection con) {
        this.con = con;
        try {
            this.cmdInsertar = con.prepareStatement(TEMPLATE_INSERTAR,Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int registrarGenero(Genero genero) throws SQLException {
        int indiceGenero = 0;
        if(this.cmdInsertar!=null){
            this.cmdInsertar.setString(1,genero.getNombre());
            this.cmdInsertar.setString(2,genero.getDescripcion());
            this.cmdInsertar.execute();
            ResultSet rs = cmdInsertar.getGeneratedKeys();
            while (rs.next()){
                indiceGenero = rs.getInt(1);
            }
        }
        /*try {
            Statement statement = con.createStatement();
            StringBuilder sentence = new StringBuilder("insert into genero(nombreGenero,descripcion)");
            sentence.append("values ('");
            sentence.append(genero.getNombre());
            sentence.append("','");
            sentence.append(genero.getDescripcion());
            sentence.append("')");
            statement.execute(sentence.toString(), statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()) {
                indiceGenero = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return indiceGenero;
    }

    public List<Genero> encontrarGeneros() {
        ArrayList<Genero> listadeGenerosBD = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("Select * from genero");
            while (results.next()) {
                Genero unGenero = new Genero();
                unGenero.setId(results.getInt("idGenero"));
                unGenero.setNombre(results.getString("nombreGenero"));
                unGenero.setDescripcion(results.getString("descripcion"));
                listadeGenerosBD.add(unGenero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listadeGenerosBD;
    }
}
