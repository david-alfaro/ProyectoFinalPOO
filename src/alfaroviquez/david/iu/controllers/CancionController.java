package alfaroviquez.david.iu.controllers;

import alfaroviquez.david.bl.entidades.*;
import alfaroviquez.david.controlador.Controlador;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class CancionController implements Initializable {
    @FXML
    private TableView<Cancion> tblCanciones;

    @FXML
    private TextField txtNombreCancion;

    @FXML
    private DatePicker dateCancion;

    @FXML
    private ComboBox cbxArtista;

    @FXML
    private ComboBox cbxCompositor;

    @FXML
    private ComboBox cbxAlbum;

    @FXML
    private ComboBox cbxGenero;


    @FXML
    private TableColumn<Cancion, String> colNombreCancion;

    @FXML
    private TableColumn<?, ?> colCompositor;

    @FXML
    private TableColumn<?, ?> colGenero;

    @FXML
    private TableColumn<?, ?> colAlbum;
    @FXML
    private TableColumn<Cancion, String> colMp3file;
    @FXML
    private TableColumn<Cancion, Integer> colCancionId;

    @FXML
    private Slider progressbar;

    @FXML
    private TableColumn<Cancion, LocalDate> colFechaLanzamiento;

    private int CancionID;

    String cancionMP3;
    String mp3ToPlay;
    private MediaPlayer mediaPlayer;
    Controlador controlador = new Controlador();

    public void subirCancion(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sube una cancion");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("MP3 File", "MP3"));
        File mp3File = fileChooser.showOpenDialog(null);
        if (mp3File != null) {
            cancionMP3 = mp3File.getAbsolutePath();
        }
    }


    public void btnGuardar(ActionEvent actionEvent) {
        String nombreCancion = txtNombreCancion.getText();
        String mp3 = cancionMP3;
        LocalDate fechaLanzamiento = dateCancion.getValue();
        String genero = String.valueOf(cbxGenero.getValue());
        String compositor = String.valueOf(cbxCompositor.getValue());
        String artista = String.valueOf(cbxArtista.getValue());
        String album = String.valueOf(cbxAlbum.getValue());
        controlador.registrarCancion(nombreCancion,mp3,fechaLanzamiento,genero,compositor,artista,album);
        mostrarCanciones();
    }


    public void btnEditar(ActionEvent actionEvent) {
        String update = "update cancion set nombreCancion = '"+txtNombreCancion.getText()+"', mp3='"+cancionMP3+"', fechaLanzamiento='"+dateCancion.getValue()+"' where idCancion='"+CancionID+"'";
        executeQuery(update);
        mostrarCanciones();
    }

    public void btnEliminar(ActionEvent actionEvent) {
        String delete = "delete from cancion where idCancion='"+CancionID+"'";
        executeQuery(delete);
        mostrarCanciones();
    }

    //llenar comboboxes
    GeneroController generoController = new GeneroController();
    ObservableList<Genero> getListaGenero = generoController.getGeneros();

    private void cargarCBXGenero() {
        for (Genero unGenero : getListaGenero
        ) {
            cbxGenero.getItems().addAll(unGenero.getNombre());
        }
    }

    ArtistaController artistaController = new ArtistaController();
    ObservableList<Artista> getListaArtistas = artistaController.getArtistas();

    private void cargarCBXArtistas() {
        for (Artista unArtista : getListaArtistas
        ) {
            cbxArtista.getItems().addAll(unArtista.getNombre());
        }
    }

    CompositorController compositorController = new CompositorController();
    ObservableList<Compositor> getListaCompositor = compositorController.getCompositores();

    private void cargarCBXCOmpositor() {
        for (Compositor comp : getListaCompositor
        ) {
            cbxCompositor.getItems().addAll(comp.getNombre());
        }
    }

    AlbumController albumController = new AlbumController();
    ObservableList<Album> getListaAlbum = albumController.getAlbum();

    private void cargarCBXAlbum() {
        for (Album album : getListaAlbum
        ) {
            cbxAlbum.getItems().addAll(album.getNombre());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarCBXGenero();
        cargarCBXArtistas();
        cargarCBXCOmpositor();
        cargarCBXAlbum();
        mostrarCanciones();
    }

    public void playbutton(ActionEvent actionEvent) {
        Media media = new Media(new File(mp3ToPlay).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, Duration t1) {
                progressbar.setValue(t1.toSeconds());
            }
        });
        progressbar.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mediaPlayer.seek(Duration.seconds(progressbar.getValue()));
            }
        });
        progressbar.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mediaPlayer.seek(Duration.seconds(progressbar.getValue()));
            }
        });
        mediaPlayer.setOnReady(new Runnable() {
            @Override
            public void run() {
                Duration total = media.getDuration();
                progressbar.setMax(total.toSeconds());
            }
        });
        mediaPlayer.play();
    }

    public void stopbutton(ActionEvent actionEvent) {
        mediaPlayer.stop();

    }

    public void pausebutton(ActionEvent actionEvent) {
        mediaPlayer.pause();
    }

    public ObservableList<Cancion> getCanciones(){
        ObservableList<Cancion> listaCanciones = FXCollections.observableArrayList();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connectDB = dataBaseConnection.getConnection();
        String query = "select * from cancion";
        try{
            Statement st = connectDB.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Cancion cancion = new Cancion();
                cancion.setId(rs.getInt("idCancion"));
                cancion.setNombre(rs.getString("nombreCancion"));
                cancion.setFechaLanzamiento(rs.getDate("fechaLanzamiento").toLocalDate());
                cancion.setMp3(rs.getString("mp3"));
                listaCanciones.add(cancion);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaCanciones;
    }

    private void mostrarCanciones(){
        ObservableList<Cancion> lista = getCanciones();
        colNombreCancion.setCellValueFactory(new PropertyValueFactory<Cancion,String>("nombre"));
        colFechaLanzamiento.setCellValueFactory(new PropertyValueFactory<Cancion,LocalDate>("fechaLanzamiento"));
        colMp3file.setCellValueFactory(new PropertyValueFactory<Cancion,String>("mp3"));
        colCancionId.setCellValueFactory(new PropertyValueFactory<Cancion,Integer>("id"));
        tblCanciones.setItems(lista);

    }

    private void executeQuery(String qry){
        DataBaseConnection connect  = new DataBaseConnection();
        Connection connectDB = connect.getConnection();
        try{
            Statement st = connectDB.createStatement();
            st.executeUpdate(qry);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void handleMouseAction(MouseEvent mouseEvent) {

        Cancion cancion = tblCanciones.getSelectionModel().getSelectedItem();
        txtNombreCancion.setText(cancion.getNombre());
        dateCancion.setValue(cancion.getFechaLanzamiento());
        mp3ToPlay = cancion.getMp3();
        CancionID = cancion.getId();
        System.out.println(mp3ToPlay);
    }

    public void limpiarCampos(ActionEvent actionEvent) {
        txtNombreCancion.setText("");
        dateCancion.setValue(null);
        cbxAlbum.setValue(null);
        cbxGenero.setValue(null);
        cbxArtista.setValue(null);
        cbxCompositor.setValue(null);

    }
}
