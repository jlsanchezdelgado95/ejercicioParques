/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Parques;

import Datos.GestionBD;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Parques;

/**
 * FXML Controller class
 *
 * @author Kokekui
 */
public class VistaParquesController implements Initializable {

    @FXML
    private TextField tfIdParque;
    @FXML
    private TextField tfExtension;
    @FXML
    private TextField tfIdComunidad;
    @FXML
    private TextField tfNombreParque;
    private List<Parques> listParques = new ArrayList<>();
    private int posicionActual = 0;
    private GestionBD gestion;
    @FXML
    private Label lSizeParques;
    @FXML
    private Label lConexion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void cargarParques() {
        try {
            listParques = gestion.rellenarListaParques();
            lSizeParques.setText(String.valueOf(listParques.size()));
            lConexion.setText("CONECTADO");
        } catch (SQLException ex) {
            Logger.getLogger(ParquesInsertController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Primero(ActionEvent event) {
        posicionActual = 0;
        tfIdParque.setText(String.valueOf(listParques.get(posicionActual).getIdParque()));
        tfNombreParque.setText(listParques.get(posicionActual).getNombre());
        tfExtension.setText(String.valueOf(listParques.get(posicionActual).getExtension()));
        tfIdComunidad.setText(String.valueOf(listParques.get(posicionActual).getIdComunidad()));
    }

    @FXML
    private void Anterior(ActionEvent event) {
        if (posicionActual != 0) {
            posicionActual = posicionActual - 1;
            tfIdParque.setText(String.valueOf(listParques.get(posicionActual).getIdParque()));
            tfNombreParque.setText(listParques.get(posicionActual).getNombre());
            tfExtension.setText(String.valueOf(listParques.get(posicionActual).getExtension()));
            tfIdComunidad.setText(String.valueOf(listParques.get(posicionActual).getIdComunidad()));
        }
    }

    @FXML
    private void Siguiente(ActionEvent event) {
        if (posicionActual < listParques.size() - 1) {
            posicionActual = posicionActual + 1;
            tfIdParque.setText(String.valueOf(listParques.get(posicionActual).getIdParque()));
            tfNombreParque.setText(listParques.get(posicionActual).getNombre());
            tfExtension.setText(String.valueOf(listParques.get(posicionActual).getExtension()));
            tfIdComunidad.setText(String.valueOf(listParques.get(posicionActual).getIdComunidad()));
        }
    }

    @FXML
    private void Ultimo(ActionEvent event) {
        posicionActual = listParques.size() - 1;
        tfIdParque.setText(String.valueOf(listParques.get(posicionActual).getIdParque()));
        tfNombreParque.setText(listParques.get(posicionActual).getNombre());
        tfExtension.setText(String.valueOf(listParques.get(posicionActual).getExtension()));
        tfIdComunidad.setText(String.valueOf(listParques.get(posicionActual).getIdComunidad()));
    }

    public GestionBD getGestion() {
        return gestion;
    }

    public void setGestion(GestionBD gestion) {
        this.gestion = gestion;
    }

}
