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
import javafx.scene.control.ComboBox;
import modelo.Parques;

/**
 * FXML Controller class
 *
 * @author Kokekui
 */
public class ParquesDeleteController implements Initializable {

    @FXML
    private ComboBox<Parques> cbParques;
    private GestionBD gestion;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void cargarParques() {
        try {
            cbParques.setItems((FXCollections.observableArrayList(gestion.rellenarListaParques())));
            cbParques.getSelectionModel().selectFirst();
        } catch (SQLException ex) {
            Logger.getLogger(ParquesInsertController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void borrarParque(ActionEvent event) throws SQLException {
        Parques parque = cbParques.getSelectionModel().getSelectedItem();
        int numFilas = gestion.borrarParque(parque.getIdParque());
        if (numFilas > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacion");
            alert.setHeaderText("Mas informacion");
            alert.setContentText("Se ha borrado correctamente");
            alert.showAndWait();
        }
    }

// GETS Y SETS
    public GestionBD getGestion() {
        return gestion;
    }

    public void setGestion(GestionBD gestion) {
        this.gestion = gestion;
    }

    public ComboBox<Parques> getCbParques() {
        return cbParques;
    }

    public void setCbParques(ComboBox<Parques> cbParques) {
        this.cbParques = cbParques;
    }
    
    

}
