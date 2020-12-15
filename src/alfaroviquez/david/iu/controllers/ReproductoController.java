package alfaroviquez.david.iu.controllers;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;



public class ReproductoController implements Initializable {

    private MediaPlayer mediaPlayer;
    String pathCancion;
    @FXML
    private ImageView imageviewReproductor;
    @FXML
    private MediaView mediaView;

    @FXML
    private Slider progressBar;

    @FXML
    private Slider volumeBar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File fileImagenReproductor = new File("Imagenes/imagenReproductor.jpg");
        Image imagenReproductor = new Image(fileImagenReproductor.toURI().toString());
        imageviewReproductor.setImage(imagenReproductor);
    }


    public void handleCanciones(MouseEvent mouseEvent) {
        try{
            Stage cancionStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../escenas/cancion.fxml"));
            cancionStage.setScene(new Scene(root));
            cancionStage.setTitle("MUSICAPP | Registro de canciones");
            cancionStage.setResizable(false);
            cancionStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void handleArtistas(MouseEvent mouseEvent) {
        try{
            Stage cancionStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../escenas/artista.fxml"));
            cancionStage.setScene(new Scene(root));
            cancionStage.setTitle("MUSICAPP | Registro de artistas");
            cancionStage.setResizable(false);
            cancionStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void handleGenero(MouseEvent mouseEvent) {
        try{
            Stage generoStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../escenas/genero.fxml"));
            generoStage.setScene(new Scene(root));
            generoStage.setTitle("MUSICAPP | Registro de generos");
            generoStage.setResizable(false);
            generoStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void handleAlbums(MouseEvent mouseEvent) {
        try{
            Stage generoStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../escenas/album.fxml"));
            generoStage.setScene(new Scene(root));
            generoStage.setTitle("MUSICAPP | Registro de album");
            generoStage.setResizable(false);
            generoStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void handleCompositores(MouseEvent mouseEvent) {
        try{
            Stage generoStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../escenas/compositor.fxml"));
            generoStage.setScene(new Scene(root));
            generoStage.setTitle("MUSICAPP | Registro de compositores");
            generoStage.setResizable(false);
            generoStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void subirCancion(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Subir cancion");
        File file = fileChooser.showOpenDialog(null);
        pathCancion = file.toURI().toString();

        if(pathCancion!=null){
            Media media = new Media(pathCancion);
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);

            mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                @Override
                public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, Duration t1) {
                    progressBar.setValue(t1.toSeconds());
                }
            });
            progressBar.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    mediaPlayer.seek(Duration.seconds(progressBar.getValue()));
                }
            });
            progressBar.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    mediaPlayer.seek(Duration.seconds(progressBar.getValue()));
                }
            });
            mediaPlayer.setOnReady(new Runnable() {
                @Override
                public void run() {
                    Duration total = media.getDuration();
                    progressBar.setMax(total.toSeconds());
                }
            });
            volumeBar.setValue(mediaPlayer.getVolume()*100);
            volumeBar.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    mediaPlayer.setVolume(volumeBar.getValue()/100);
                }
            });

            mediaPlayer.play();
        }
    }

    public void handlePlay(ActionEvent actionEvent) {
        mediaPlayer.play();
    }

    public void handelPausa(ActionEvent actionEvent) {
        mediaPlayer.pause();
    }

    public void handleStop(ActionEvent actionEvent) {
        mediaPlayer.stop();
    }

    public void handle10sminus(ActionEvent actionEvent) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(-10)));
    }

    public void handle10splus(ActionEvent actionEvent) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(10)));
    }


}
