package alfaroviquez.david.iu.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ReproductoController implements Initializable {

    @FXML
    private ImageView imageviewReproductor;

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
}
