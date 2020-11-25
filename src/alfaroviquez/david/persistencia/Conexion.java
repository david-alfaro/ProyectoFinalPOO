package alfaroviquez.david.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    protected Connection conexion;
    private final String DRIVER="com.mysql.cj.jdbc.Driver";
    private final String DB_URL="jdbc:mysql://localhost:3306/musicapp";
    private final String USER = "root";
    private final String PWD = "12345";

    public void conectar(){
        try {
            Connection conexion = DriverManager.getConnection(DB_URL,USER,PWD);
            Class.forName(DRIVER);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();

        }
    }

    public void cerrarConexion() throws SQLException{
        if(!conexion.isClosed()){
            conexion.close();
        }
    }
}
