/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Filtrados;

import Datos.GestionBD;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelo.Comunidad;
import modelo.Parques;
import vista.Parques.ParquesInsertController;

/**
 * FXML Controller class
 *
 * @author Kokekui
 */
public class FiltrarParquesPorComunidadController implements Initializable {

    private GestionBD gestion;
    @FXML
    private ComboBox<Comunidad> cbComunidades;
    @FXML
    private TableColumn<Parques, Integer> idParque;
    @FXML
    private TableColumn<Parques, String> nombreParque;
    @FXML
    private TableColumn<Parques, Double> extension;
    @FXML
    private TableView<Parques> ParquesTableView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void cargarLista() {
        try {
            cbComunidades.setItems(FXCollections.observableArrayList(gestion.rellenarListaComunidades()));
            cbComunidades.getSelectionModel().selectFirst();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ParquesInsertController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //GETS Y SETS
    public GestionBD getGestion() {
        return gestion;
    }

    public void setGestion(GestionBD gestion) {
        this.gestion = gestion;
    }

}
