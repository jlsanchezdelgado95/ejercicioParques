/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Parques;

import Datos.GestionBD;
import java.net.URL;
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
import modelo.Comunidad;
import modelo.Parques;

/**
 * FXML Controller class
 *
 * @author Kokekui
 */
public class ParquesInsertController implements Initializable {

    @FXML
    private TextField tfIdParque;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfExtension;
    @FXML
    private Button bGuardar;
    @FXML
    private ComboBox<Comunidad> cbComunidades;
    private GestionBD gestion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Guardar(ActionEvent event) throws SQLException {
        Comunidad comu = cbComunidades.getSelectionModel().getSelectedItem();
        Parques p = new Parques((Integer.valueOf(tfIdParque.getText())), tfNombre.getText(), Double.valueOf(tfExtension.getText()), Integer.valueOf(comu.getId()));
        int numFilas = gestion.insertarParque(p);
        if (numFilas > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacion");
            alert.setHeaderText("Mas informacion");
            alert.setContentText("Se ha introducido correctamente");
            alert.showAndWait();
        }
    }

    public void cargarLista() {
        try {
            cbComunidades.setItems((FXCollections.observableArrayList(gestion.rellenarListaComunidades())));
            cbComunidades.getSelectionModel().selectFirst();
        } catch (SQLException ex) {
            Logger.getLogger(ParquesInsertController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // gets y sets
    public TextField getTfIdParque() {
        return tfIdParque;
    }

    public void setTfIdParque(TextField tfIdParque) {
        this.tfIdParque = tfIdParque;
    }

    public TextField getTfNombre() {
        return tfNombre;
    }

    public void setTfNombre(TextField tfNombre) {
        this.tfNombre = tfNombre;
    }

    public TextField getTfExtension() {
        return tfExtension;
    }

    public void setTfExtension(TextField tfExtension) {
        this.tfExtension = tfExtension;
    }

    public Button getbGuardar() {
        return bGuardar;
    }

    public void setbGuardar(Button bGuardar) {
        this.bGuardar = bGuardar;
    }

    public ComboBox<Comunidad> getCbComunidades() {
        return cbComunidades;
    }

    public void setCbComunidades(ComboBox<Comunidad> cbComunidades) {
        this.cbComunidades = cbComunidades;
    }

    public GestionBD getGestion() {
        return gestion;
    }

    public void setGestion(GestionBD gestion) {
        this.gestion = gestion;
    }

}
