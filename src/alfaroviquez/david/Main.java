package alfaroviquez.david;

import alfaroviquez.david.controlador.Controlador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("./iu/escenas/inicio.fxml"));
        primaryStage.setTitle("MusicApp | Bienvenido");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
        //Controlador controlador = new Controlador();
        //controlador.ejecutarPrograma();
    }
}
