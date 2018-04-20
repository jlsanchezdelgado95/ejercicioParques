/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioparques;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Kokekui
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label lConexion;
    @FXML
    private TextField tfIdParque;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfExtension;
    @FXML
    private Button bGuardar;
    @FXML
    private ComboBox<?> cbComunidades;
    @FXML
    private Button bBorrar;
    @FXML
    private Button bInsertar;
    @FXML
    private Button bModificar;
    @FXML
    private TextField tfUsuario;
    @FXML
    private TextField tfContraseña;
    @FXML
    private Button bConectar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Guardar(ActionEvent event) {
    }

    @FXML
    private void Borrar(ActionEvent event) {
    }

    @FXML
    private void Insertar(ActionEvent event) {
    }

    @FXML
    private void Modificar(ActionEvent event) {
    }

    @FXML
    private void Conectar(ActionEvent event) {
    }
    
}
