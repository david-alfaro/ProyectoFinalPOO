package alfaroviquez.david.iu.controllers;

import alfaroviquez.david.controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;


public class RegistroAdminController {
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrimerApellido;

    @FXML
    private TextField txtSegundoApellido;

    @FXML
    private TextField txtEmail;


    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private PasswordField txtContrasenna;

    @FXML
    private PasswordField txtConformarContrasenna;

    @FXML
    private ImageView imgVwImagenPerfil;


    @FXML
    private Label lblAlerta;

    private String imagenBD;

    Controlador controlador = new Controlador();
    public void btnSubirImagen(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Busca una imagen de perfil");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        //Abre la ventana para buscar la imagen
        File imgFile = fileChooser.showOpenDialog(null);
        //Muestra la imagen en el imageview
        if(imgFile!=null){
            imagenBD = imgFile.getAbsolutePath();
            System.out.println(imagenBD);
            Image imagenPeril = new Image("file:"+imgFile.getAbsolutePath());
            imgVwImagenPerfil.setImage(imagenPeril);
        }


    }

    public void btnRegistrar(ActionEvent actionEvent) {
        String nombre = txtNombre.getText();
        String apellido1 = txtPrimerApellido.getText();
        String apellido2 = txtSegundoApellido.getText();
        String correo = txtEmail.getText();
        String nombreUsuario = txtNombreUsuario.getText();
        String imagenPerfil = imagenBD;
        String contrasenna = txtContrasenna.getText();
        String confirmaContrasenna = txtConformarContrasenna.getText();
        if(contrasenna.equalsIgnoreCase(confirmaContrasenna)){
            controlador.crearAdmin(nombre,nombreUsuario,apellido1,apellido2,correo,contrasenna,imagenPerfil);
            lblAlerta.setText("Resgistro exitoso");
            limpiarCampos();
        }else{
            lblAlerta.setText("Las contraseñas no son iguales");
        }


    }

    public void limpiarCampos(){
        txtNombre.setText("");
        txtNombreUsuario.setText("");
        txtPrimerApellido.setText("");
        txtSegundoApellido.setText("");
        txtEmail.setText("");
        txtContrasenna.setText("");
        txtConformarContrasenna.setText("");

    }


}
