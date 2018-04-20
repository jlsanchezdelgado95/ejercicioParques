/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Datos.GestionBD;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.Parques;

/**
 * FXML Controller class
 *
 * @author Kokekui
 */
public class InsertController implements Initializable {

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
    private GestionBD gestion;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargaListaComunidades();
    }
    
    private void cargaListaComunidades(){
                try {
            cbComunidades.setItems(FXCollections.observableArrayList(gestion.rellenarListaComunidades()));
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(InsertController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Guardar(ActionEvent event) throws SQLException {
        String sql = ("insert into " + " parque(id,nombre,extension,idcomunidad) "
                + " values(?,?,?,?)");
        Parques p = new Parques((Integer.valueOf(tfIdParque.getText())), tfNombre.getText(), Double.valueOf(tfExtension.getText()), Integer.valueOf(cbComunidades.getSelectionModel().getSelectedItem().toString()));
        int numFilas = gestion.insertarParque(p);
        if (numFilas > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacion");
            alert.setHeaderText("Mas informacion");
            alert.setContentText("Se ha introducido correctamente");
            alert.showAndWait();
        }
    }

}
