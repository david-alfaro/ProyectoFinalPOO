package alfaroviquez.david.iu.controllers;

import alfaroviquez.david.bl.entidades.Album;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AlbumController implements Initializable {
    Controlador controlador = new Controlador();
    @FXML
    private TableView<Album> tblAlbum;

    @FXML
    private TableColumn<Album, String> colNombrealbum;

    @FXML
    private TableColumn<Album, LocalDate> colfechaLanzamiento;

    @FXML
    private TextField txtNombreAlbum;

    @FXML
    private DatePicker dateLanzamientoAlbum;

    @FXML
    private ImageView imageAlbum;

    private String imagenAlbumBD;
    private String mp3BD;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mostrarAlbum();
    }
    public void subirImagenAlbum(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar una imagen de album");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        File imgFile = fileChooser.showOpenDialog(null);
        if(imgFile!=null){
            imagenAlbumBD = imgFile.getAbsolutePath();
            Image imagenAlbum = new Image("file: "+imgFile.getAbsolutePath());
            imageAlbum.setImage(imagenAlbum);
        }

    }

    public void subirCancion(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Subir una cancion");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("MP3 File","MP3"));
        File mp3File = fileChooser.showOpenDialog(null);
        if(mp3File!=null){
            mp3BD = mp3File.getAbsolutePath();
        }
    }

    public void btnGuardar(ActionEvent actionEvent) {
        String nombreAlbum = txtNombreAlbum.getText();
        LocalDate fechalanzamiento = dateLanzamientoAlbum.getValue();
        String imagendeAlbum = imagenAlbumBD;
        String mp3 = mp3BD;
        controlador.crearAlbum(nombreAlbum,fechalanzamiento,imagendeAlbum,mp3);
        mostrarAlbum();
    }

    public void btnEditar(ActionEvent actionEvent) {
    }

    public void btnEliminar(ActionEvent actionEvent) {
    }


    private ObservableList<Album> getAlbum(){
        ObservableList<Album> listaAlbum = FXCollections.observableArrayList();
        DataBaseConnection connection = new DataBaseConnection();
        Connection connectDB = connection.getConnection();
        String query = "select * from album";
        try{
            Statement st = connectDB.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Album album = new Album();
                album.setNombre(rs.getString("nombreAlbum"));
                album.setImagen(rs.getString("imagenAlbum"));
                album.setFechalanzamiento(rs.getDate("fechaLanzamiento").toLocalDate());
                album.setCanciones(rs.getString("mp3file"));
                listaAlbum.add(album);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaAlbum;
    }

    private void mostrarAlbum(){
        ObservableList<Album> lista = getAlbum();
        colNombrealbum.setCellValueFactory(new PropertyValueFactory<Album,String>("nombre"));
        colfechaLanzamiento.setCellValueFactory(new PropertyValueFactory<Album,LocalDate>("fechalanzamiento"));
        tblAlbum.setItems(lista);

    }

    public void handleMouseEvent(MouseEvent mouseEvent) {
        Album album = tblAlbum.getSelectionModel().getSelectedItem();
        txtNombreAlbum.setText(album.getNombre());
        dateLanzamientoAlbum.setValue(album.getFechalanzamiento());
        String imagenReload = album.getImagen();
        Image image = new Image("file:"+imagenReload);
        imageAlbum.setImage(image);
    }
}
