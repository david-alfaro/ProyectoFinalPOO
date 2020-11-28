package alfaroviquez.david.persistencia;

import alfaroviquez.david.bl.entidades.Compositor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompositorDAO {
     Connection con;

     public CompositorDAO(Connection con){
         this.con=con;
     }

     public void registrarCompositor(Compositor compositor){
         try{
             Statement statement = con.createStatement();
             StringBuilder sentence = new StringBuilder("insert into compositor (nombreCompositor,apellido1,apellido2,edad,paisNacimiento)");
             sentence.append("values ('");
             sentence.append(compositor.getNombre());
             sentence.append("','");
             sentence.append(compositor.getApellido1());
             sentence.append("','");
             sentence.append(compositor.getApellido2());
             sentence.append("',");
             sentence.append(compositor.getEdad());
             sentence.append(",'");
             sentence.append(compositor.getPaisNacimiento());
             sentence.append("')");
             statement.execute(sentence.toString());

         }catch (SQLException e){
             e.printStackTrace();
         }
     }

     public List<Compositor> encontrarCompositores(){
         ArrayList<Compositor> resultadosBD = new ArrayList<>();
         try{
             Statement statement = con.createStatement();
             ResultSet results = statement.executeQuery("Select * from compositor");
             while(results.next()){
                 Compositor unCompositor = new Compositor();
                 unCompositor.setNombre(results.getString("nombreCompositor"));
                 unCompositor.setApellido1(results.getString("apellido1"));
                 unCompositor.setApellido2(results.getString("apellido2"));
                 unCompositor.setEdad(results.getInt("edad"));
                 unCompositor.setPaisNacimiento(results.getString("paisNacimiento"));
                 resultadosBD.add(unCompositor);
             }
         }catch (SQLException e){
             e.printStackTrace();
         }
         return resultadosBD;
     }


}
