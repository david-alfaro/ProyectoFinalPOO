package alfaroviquez.david.persistencia;


import alfaroviquez.david.bl.entidades.UsuarioFinal;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UsuarioFinalDAO  {

    Connection con;

    public UsuarioFinalDAO(Connection con){
        this.con=con;
    }

    public void resgitrarUsuario(UsuarioFinal usuario) {
        try {

            Statement statement = con.createStatement();
            StringBuilder sentence = new StringBuilder("insert into usuario (nombre,nombreUsuario,apellido1,apellido2,correo,avatar,contrasenna,edad,pais,identificacion)");
            sentence.append("values ('");
            sentence.append(usuario.getNombre());
            sentence.append("','");
            sentence.append(usuario.getNombreUsuario());
            sentence.append("','");
            sentence.append(usuario.getApellido1());
            sentence.append("','");
            sentence.append(usuario.getApellido2());
            sentence.append("','");
            sentence.append(usuario.getCorreo());
            sentence.append("','");
            sentence.append(usuario.getImagen());
            sentence.append("','");
            sentence.append(usuario.getContrasenna());
            sentence.append("',");
            sentence.append(usuario.getEdad());
            sentence.append(",'");
            sentence.append(usuario.getPais());
            sentence.append("','");
            sentence.append(usuario.getIdentificacion());
            sentence.append("')");
            System.out.println(sentence.toString());
            statement.execute(sentence.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<UsuarioFinal> listarUsuarios() {
        ArrayList<UsuarioFinal> resultados = new ArrayList<>();
        try {

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from usuario");

            while (resultSet.next()) {
                UsuarioFinal unUsuario = new UsuarioFinal();
                unUsuario.setNombre(resultSet.getString("nombre"));
                unUsuario.setNombreUsuario(resultSet.getString("nombreUsuario"));
                unUsuario.setApellido1(resultSet.getString("apellido1"));
                unUsuario.setApellido2(resultSet.getString("apellido2"));
                unUsuario.setCorreo(resultSet.getString("correo"));
                unUsuario.setImagen(resultSet.getString("avatar"));
                unUsuario.setContrasenna(resultSet.getString("contrasenna"));
                unUsuario.setEdad(resultSet.getInt("edad"));
                unUsuario.setIdentificacion(resultSet.getString("identificacion"));
                unUsuario.setPais(resultSet.getString("pais"));
                resultados.add(unUsuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultados;
    }


}
