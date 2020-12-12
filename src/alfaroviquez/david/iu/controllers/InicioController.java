package alfaroviquez.david.iu.controllers;

import alfaroviquez.david.bl.logica.Gestor;
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

import java.sql.*;

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
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connectBD = dataBaseConnection.getConnection();

        String verificacion = "select count(1) from usuario where identificacion = '"+txtIdentifiacion.getText()+"' and contrasenna='"+txtContrasenna.getText()+"'";
        try{
            Statement statement = connectBD.createStatement();
            ResultSet resultSet = statement.executeQuery(verificacion);
            while (resultSet.next()){
                if(resultSet.getInt(1)==1){
                    irAlReproductor();
                }else {
                    lblAlerta.setText("Usuario o contraseña inválidas");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void irAlReproductor() {
        try{
            Stage reproductorStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../escenas/reproductor.fxml"));
            reproductorStage.setScene(new Scene(root));
            reproductorStage.setTitle("MUSICAPP | Reproductor");
            reproductorStage.setResizable(false);
            reproductorStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
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
