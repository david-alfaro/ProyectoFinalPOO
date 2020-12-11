package alfaroviquez.david.iu.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InicioController {

    @FXML
    private TextField txtIdentifiacion;

    @FXML
    private Label lblAlerta;

    @FXML
    private PasswordField txtContrasenna;

    public void handleInisioSesion(ActionEvent actionEvent) {
        if(txtContrasenna.getText().isBlank()==false && txtIdentifiacion.getText().isBlank()==false){
            validarInicioSesion();
        }else{
            lblAlerta.setText("Digite usuario y contraseña. Sino tiene usuario, registrese en la App");
        }
    }

    private void validarInicioSesion() {
    }

    public void handleRegistro(ActionEvent actionEvent) {
        try{
            Stage registerStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../escenas/register.fxml"));
            registerStage.setScene(new Scene(root));
            registerStage.setTitle("MUSICAPP | Registro");
            registerStage.setResizable(false);
            registerStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
