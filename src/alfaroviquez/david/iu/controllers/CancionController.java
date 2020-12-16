package alfaroviquez.david.iu.controllers;

import alfaroviquez.david.bl.entidades.Album;
import alfaroviquez.david.bl.entidades.Artista;
import alfaroviquez.david.bl.entidades.Compositor;
import alfaroviquez.david.bl.entidades.Genero;
import alfaroviquez.david.controlador.Controlador;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class CancionController implements Initializable {
    @FXML
    private TableView<?> tblCanciones;

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

    String cancionMP3;
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
    }


    public void btnEditar(ActionEvent actionEvent) {
    }

    public void btnEliminar(ActionEvent actionEvent) {
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
    }
}
