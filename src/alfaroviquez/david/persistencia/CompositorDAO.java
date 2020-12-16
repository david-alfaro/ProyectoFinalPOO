package alfaroviquez.david.persistencia;

import alfaroviquez.david.bl.entidades.Compositor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompositorDAO {
     Connection con;

     private final String TEMPLATE_INSERT="insert into compositor (nombreCompositor,apellido1,edad,paisNacimiento,idGenero)" +
             "values(?,?,?,?,?)";
     private PreparedStatement cmdInsert;
     public CompositorDAO(Connection con){

         this.con=con;
         try{
             this.cmdInsert=con.prepareStatement(TEMPLATE_INSERT,Statement.RETURN_GENERATED_KEYS);
         }catch (SQLException e){
             e.printStackTrace();
         }
     }

     public int registrarCompositor(Compositor compositor) throws SQLException {
         int indiceCompositor=0;
         if(this.cmdInsert!=null){
             this.cmdInsert.setString(1,compositor.getNombre());
             this.cmdInsert.setString(2,compositor.getApellido1());
             this.cmdInsert.setInt(3,compositor.getEdad());
             this.cmdInsert.setString(4,compositor.getPaisNacimiento());
             this.cmdInsert.setInt(5, compositor.getGenero().getId());
             this.cmdInsert.execute();
             ResultSet rs = cmdInsert.getGeneratedKeys();
             while (rs.next()){
                 indiceCompositor = rs.getInt(1);
             }

         }
         return indiceCompositor;
     }

     public List<Compositor> encontrarCompositores(){
         ArrayList<Compositor> resultadosBD = new ArrayList<>();
         try{
             Statement statement = con.createStatement();
             ResultSet results = statement.executeQuery("Select * from compositor");
             while(results.next()){
                 Compositor unCompositor = new Compositor();
                 unCompositor.setId(results.getInt("idCompositor"));
                 unCompositor.setNombre(results.getString("nombreCompositor"));
                 unCompositor.setApellido1(results.getString("apellido1"));
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
