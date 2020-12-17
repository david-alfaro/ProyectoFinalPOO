package alfaroviquez.david.iu.controllers;

import alfaroviquez.david.bl.entidades.Genero;
import alfaroviquez.david.controlador.Controlador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class GeneroController implements Initializable {
    @FXML
    private TextField txtNombreGenero;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TableView<Genero> tblGenero;

    @FXML
    private TableColumn<Genero, String> colNombreGenero;

    @FXML
    private TableColumn<Genero, String> colDescripcionGenero;

    @FXML
    private TableColumn<Genero, Integer> colGeneroId;

    @FXML
    private Label lblAlerta;

    private int GeneroId;
    Controlador controlador = new Controlador();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mostrarGeneros();
    }

    public void handleGuardarGenero(ActionEvent actionEvent) {
        String nombreGenero = txtNombreGenero.getText();
        String descripcion = txtDescripcion.getText();
        if (txtDescripcion.getText().isBlank() == false && txtNombreGenero.getText().isBlank() == false) {
            controlador.registrarGenero(nombreGenero, descripcion);
            mostrarGeneros();
            lblAlerta.setText("Registro exitoso");
        } else {
            lblAlerta.setText("Digite el nombre del genero y una descripcion.");
        }
    }

    public void handleActualizarGenero(ActionEvent actionEvent) {
        String query = "update genero set nombreGenero='"+txtNombreGenero.getText()+"', descripcion='"+txtDescripcion.getText()+"' where idGenero='"+GeneroId+"'";
        executeQuery(query);
        mostrarGeneros();
    }

    public void handleEliminarGenero(ActionEvent actionEvent) {
        String query = "delete from genero where idGenero='"+GeneroId+"'";
        executeQuery(query);
        mostrarGeneros();
    }
    public void handleLimpiarCampos(ActionEvent actionEvent) {
        txtNombreGenero.setText("");
        txtDescripcion.setText("");

    }

    public ObservableList<Genero> getGeneros() {
        ObservableList<Genero> listaGeneros = FXCollections.observableArrayList();
        DataBaseConnection connection = new DataBaseConnection();
        Connection connecBD = connection.getConnection();
        String query = "select * from genero";
        try {
            Statement statement = connecBD.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Genero unGenero = new Genero();
                unGenero.setId(resultSet.getInt("idGenero"));
                unGenero.setNombre(resultSet.getString("nombreGenero"));
                unGenero.setDescripcion(resultSet.getString("descripcion"));
                listaGeneros.add(unGenero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaGeneros;
    }

    private void mostrarGeneros(){
        ObservableList<Genero> lista = getGeneros();
        colNombreGenero.setCellValueFactory(new PropertyValueFactory<Genero,String>("nombre"));
        colDescripcionGenero.setCellValueFactory(new PropertyValueFactory<Genero,String>("descripcion"));
        colGeneroId.setCellValueFactory(new PropertyValueFactory<Genero,Integer>("id"));
        tblGenero.setItems(lista);
    }


    public void handleMouseAction(MouseEvent mouseEvent) {
        Genero unGenero = tblGenero.getSelectionModel().getSelectedItem();
        txtNombreGenero.setText(String.valueOf(unGenero.getNombre()));
        txtDescripcion.setText(String.valueOf(unGenero.getDescripcion()));
        GeneroId = unGenero.getId();
    }

    private void executeQuery(String query){
        DataBaseConnection connection = new DataBaseConnection();
        Connection connectBD = connection.getConnection();
        try{
            Statement statement = connectBD.createStatement();
            statement.executeUpdate(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
