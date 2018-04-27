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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private ObservableList<Comunidad> listComu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void cargarListas() {
        try {
            listComu = FXCollections.observableArrayList(gestion.rellenarListaComunidades());
            cbComunidades.setItems(FXCollections.observableArrayList(listComu));
            cbComunidades.getSelectionModel().selectFirst();
            ParquesTableView.setItems(FXCollections.observableArrayList(gestion.rellenarListaParques()));
            idParque.setCellValueFactory(new PropertyValueFactory<>("idParque"));
            nombreParque.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            extension.setCellValueFactory(new PropertyValueFactory<>("extension"));
        } catch (SQLException ex) {
            Logger.getLogger(ParquesInsertController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void filtrar(ActionEvent event) throws SQLException {
        Comunidad comu = cbComunidades.getValue();
        int comuId = Integer.valueOf(comu.getId());
        ParquesTableView.setItems(FXCollections.observableArrayList(gestion.buscarParques(comuId)));
            idParque.setCellValueFactory(new PropertyValueFactory<>("idParque"));
            nombreParque.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            extension.setCellValueFactory(new PropertyValueFactory<>("extension"));
    }

    //GETS Y SETS
    public GestionBD getGestion() {
        return gestion;
    }

    public void setGestion(GestionBD gestion) {
        this.gestion = gestion;
    }

}
