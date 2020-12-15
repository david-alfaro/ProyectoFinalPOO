package alfaroviquez.david.persistencia;

import alfaroviquez.david.bl.entidades.Administrador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministrativoDAO {
    Connection con;

    private final String  TEMPLATE_INSERT = "insert into administrador (nombre,nombreUsuario,apellido1,apellido2,correo,avatar,contransenna)" +
            "values(?,?,?,?,?,?,?)";
    private final String TEMPLATE_CONSULTA = "select * from administrador";

    private PreparedStatement cmdInsert;
    private PreparedStatement qryConsulta;

    public AdministrativoDAO(Connection con){
        this.con=con;
        try{
            this.cmdInsert = con.prepareStatement(TEMPLATE_INSERT);
            this.qryConsulta = con.prepareStatement(TEMPLATE_CONSULTA);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void guardarAdmin(Administrador admin) throws SQLException {
        if(this.cmdInsert!=null){
            this.cmdInsert.setString(1,admin.getNombre());
            this.cmdInsert.setString(2,admin.getNombreUsuario());
            this.cmdInsert.setString(3,admin.getApellido1());
            this.cmdInsert.setString(4,admin.getApellido2());
            this.cmdInsert.setString(5,admin.getCorreo());
            this.cmdInsert.setString(6,admin.getImagen());
            this.cmdInsert.setString(7,admin.getContrasenna());
            this.cmdInsert.execute();
        }
    }

    public List<Administrador> getAdmin(){
        ArrayList<Administrador> listAdmin = new ArrayList<>();
        try{
            ResultSet rs = this.qryConsulta.executeQuery();
            while (rs.next()){
                Administrador admin = new Administrador();
                admin.setNombre(rs.getString("nombre"));
                admin.setNombreUsuario(rs.getString("nombreUsuario"));
                admin.setApellido1(rs.getString("apellido1"));
                admin.setApellido2(rs.getString("apellido2"));
                admin.setCorreo(rs.getString("correo"));
                admin.setImagen(rs.getString("avatar"));
                admin.setContrasenna(rs.getString("contrasenna"));
                listAdmin.add(admin);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listAdmin;
    }

}
