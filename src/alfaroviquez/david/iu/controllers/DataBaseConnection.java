package alfaroviquez.david.iu.controllers;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    public Connection con;

    public Connection getConnection(){
        String databaseName = "musicapp";
        String username = "root";
        String password = "12345";
        String url = "jdbc:mysql://localhost:3306/"+databaseName;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return con;
    }


}
