package alfaroviquez.david.iu.controllers;

import alfaroviquez.david.bl.entidades.Artista;
import alfaroviquez.david.controlador.Controlador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ArtistaController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mostrarArtista();
    }

    @FXML
    private TextField txtNombreArtista;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtNombreArtistico;

    @FXML
    private TextField txtPais;

    @FXML
    private DatePicker dateNac;

    @FXML
    private DatePicker dateDef;

    @FXML
    private TextField txtDescripcion;
    @FXML
    private TableView<Artista> tblArtistas;

    @FXML
    private TableColumn<Artista, String> colNombre;

    @FXML
    private TableColumn<Artista, String> colApellido;

    @FXML
    private TableColumn<Artista, String> colNombreArtistico;

    @FXML
    private TableColumn<Artista, String> colPais;

    @FXML
    private TableColumn<Artista, Integer> colEdad;

    @FXML
    private TableColumn<Artista, String> colDescripcion;

    Controlador controlador = new Controlador();

    public void handleGuardar(ActionEvent actionEvent) {
        String nombreArtista = txtNombreArtista.getText();
        String apellido = txtApellido.getText();
        String nombreArtistico = txtNombreArtistico.getText();
        String pais = txtPais.getText();
        LocalDate nacimiento = dateNac.getValue();
        LocalDate defuncion = dateDef.getValue();
        String descripcion = txtDescripcion.getText();
        controlador.registrarArtista(nombreArtista, apellido, nombreArtistico, pais, descripcion, nacimiento, defuncion);
        mostrarArtista();
    }

    public void handleEditar(ActionEvent actionEvent) {
       String query = "update artista set nombreArtista='"+txtNombreArtista.getText()+"',apellido1='"+txtApellido.getText()+"', nombreArtistico='"+txtNombreArtistico.getText()+"', pais ='"+txtPais.getText()+"',fechaNacimiento='"+dateNac.getValue()+"', fechaDefuncion='";
       query += dateDef.getValue()==null? null:"'"+dateDef.getValue()+"'";
       query += "',";
       query +="edad=TIMESTAMPDIFF(YEAR,fechaNacimiento,CURDATE()), descripcion ='"+txtDescripcion.getText()+"' where nombreArtista='"+txtNombreArtista.getText()+"'";
       executeQuery(query);
       mostrarArtista();
        System.out.println(query);
    }

    public void handelEmilinar(ActionEvent actionEvent) {
        String query = "delete from artista where nombreArtista = '"+txtNombreArtista.getText()+"'";
        executeQuery(query);
        mostrarArtista();
    }

    public void handleLimpiarCampos(ActionEvent actionEvent) {
        txtNombreArtista.setText("");
        txtApellido.setText("");
        txtNombreArtistico.setText("");
        txtPais.setText("");
        txtDescripcion.setText("");
        dateDef.setValue(null);
        dateNac.setValue(null);
    }

    public ObservableList<Artista> getArtistas() {
        ObservableList<Artista> listaArtistas = FXCollections.observableArrayList();
        DataBaseConnection connectionBD = new DataBaseConnection();
        Connection connectBD = connectionBD.getConnection();
        String query = "select * from artista";
        try {
            Statement statement = connectBD.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Artista artista = new Artista();
                artista.setNombre(resultSet.getString("nombreArtista"));
                artista.setApellido1(resultSet.getString("apellido1"));
                artista.setNombreArtistico(resultSet.getString("nombreArtistico"));
                artista.setPaisNacimiento(resultSet.getString("pais"));
                artista.setEdad(resultSet.getInt("edad"));
                artista.setDescripcion(resultSet.getString("descripcion"));
                listaArtistas.add(artista);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaArtistas;
    }

    private void mostrarArtista() {
        ObservableList<Artista> lista = getArtistas();
        colNombre.setCellValueFactory(new PropertyValueFactory<Artista, String>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<Artista, String>("apellido1"));
        colNombreArtistico.setCellValueFactory((new PropertyValueFactory<Artista, String>("nombreArtistico")));
        colPais.setCellValueFactory(new PropertyValueFactory<Artista, String>("paisNacimiento"));
        colEdad.setCellValueFactory(new PropertyValueFactory<Artista, Integer>("edad"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<Artista, String>("descripcion"));
        tblArtistas.setItems(lista);
    }


    public void handleMouseAction(MouseEvent mouseEvent) {
        Artista unArtista = tblArtistas.getSelectionModel().getSelectedItem();
        txtNombreArtista.setText(String.valueOf(unArtista.getNombre()));
        txtApellido.setText(String.valueOf(unArtista.getApellido1()));
        txtNombreArtistico.setText(String.valueOf(unArtista.getNombreArtistico()));
        txtDescripcion.setText(String.valueOf(unArtista.getDescripcion()));
        txtPais.setText(String.valueOf(unArtista.getPaisNacimiento()));
        dateNac.setValue(unArtista.getFechaNacimiento());
        dateDef.setValue(unArtista.getFechaDefuncion());

    }

    private void executeQuery(String query){
        DataBaseConnection connect = new DataBaseConnection();
        Connection connectDB = connect.getConnection();
        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
