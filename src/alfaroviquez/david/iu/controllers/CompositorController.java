package alfaroviquez.david.iu.controllers;


import alfaroviquez.david.bl.entidades.Compositor;
import alfaroviquez.david.bl.entidades.Genero;
import alfaroviquez.david.bl.logica.Gestor;
import alfaroviquez.david.controlador.Controlador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class CompositorController implements Initializable {
    Gestor gestor = new Gestor();
    Controlador controlador = new Controlador();
    @FXML
    private TextField txtNombreCompositor;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtPais;

    @FXML
    private ComboBox cbxGenero;
    @FXML
    private TableView<Compositor> tblCompositor;

    @FXML
    private TableColumn<Compositor, String> colNombreCompositor;

    @FXML
    private TableColumn<Compositor, String> colApellido;

    @FXML
    private TableColumn<Compositor, Integer> colEdad;

    @FXML
    private TableColumn<Compositor, String> colPais;
    @FXML
    private TableColumn<Compositor, String> colGenero;
    @FXML
    private TableColumn<Compositor, Integer> colIDCompositor;

    private int CompositiorId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cargarComboBox();
        mostrarCompositores();
    }

    public void handleGuardar(ActionEvent actionEvent) {
        String nombreCompositor = txtNombreCompositor.getText();
        String apellido = txtApellido.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String pais = txtPais.getText();
        String genero = String.valueOf(cbxGenero.getValue());
        controlador.registrarCompositor(nombreCompositor, apellido, edad, pais, genero);
        mostrarCompositores();
    }

    public void handleActualizar(ActionEvent actionEvent) {
        String query = "update compositor set nombreCompositor='"+txtNombreCompositor.getText()+"', apellido1='"+txtApellido.getText()+"',edad='"+txtEdad.getText()+"',paisNacimiento='"+txtPais.getText()+"' where idCompositor='"+CompositiorId+"'";
        executeQuery(query);
        mostrarCompositores();
        System.out.println(query);
    }

    public void handleEliminar(ActionEvent actionEvent) {
        String query = "delete from compositor where idCompositor='"+CompositiorId+"'";
        executeQuery(query);
        mostrarCompositores();
    }

    public void handleLimpiar(ActionEvent actionEvent) {
        txtNombreCompositor.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtPais.setText("");
    }

    GeneroController generoController = new GeneroController();


    ObservableList<Genero> getLista = generoController.getGeneros();

    private void cargarComboBox() {
        for (Genero ungenero : getLista) {
            cbxGenero.getItems().addAll(ungenero.getNombre());
        }
    }

    public ObservableList<Compositor> getCompositores() {
        ObservableList<Compositor> listaCompositores = FXCollections.observableArrayList();
        DataBaseConnection con = new DataBaseConnection();
        Connection connectionBD = con.getConnection();
        String query = "select * from compositor ";
        try {
            Statement statement = connectionBD.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Compositor nuevoCompositor = new Compositor();
                nuevoCompositor.setId(rs.getInt("idCompositor"));
                nuevoCompositor.setNombre(rs.getString("nombreCompositor"));
                nuevoCompositor.setApellido1(rs.getString("apellido1"));
                nuevoCompositor.setEdad(rs.getInt("edad"));
                nuevoCompositor.setPaisNacimiento(rs.getString("paisNacimiento"));
                //nuevoCompositor.setGenero(gestor.encontrarGeneroPorId(rs.getInt("idGenero")));
                listaCompositores.add(nuevoCompositor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCompositores;
    }

    private void mostrarCompositores() {
        ObservableList<Compositor> lista = getCompositores();
        colNombreCompositor.setCellValueFactory(new PropertyValueFactory<Compositor,String>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<Compositor,String>("apellido1"));
        colEdad.setCellValueFactory(new PropertyValueFactory<Compositor,Integer>("edad"));
        colPais.setCellValueFactory(new PropertyValueFactory<Compositor,String>("paisNacimiento"));
        colGenero.setCellValueFactory(new PropertyValueFactory<Compositor,String>("genero"));
        colIDCompositor.setCellValueFactory(new PropertyValueFactory<Compositor,Integer>("id"));
        tblCompositor.setItems(lista);

    }

    private void executeQuery(String query){
        DataBaseConnection con = new DataBaseConnection();
        Connection connectDB = con.getConnection();
        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void handleMouseAction(MouseEvent mouseEvent) {
        Compositor unCompositor = tblCompositor.getSelectionModel().getSelectedItem();
        txtNombreCompositor.setText(unCompositor.getNombre());
        txtApellido.setText(unCompositor.getApellido1());
        txtEdad.setText(String.valueOf(unCompositor.getEdad()));
        txtPais.setText(unCompositor.getPaisNacimiento());
        CompositiorId= unCompositor.getId();

    }
}
