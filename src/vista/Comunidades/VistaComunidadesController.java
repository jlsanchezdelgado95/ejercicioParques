/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Comunidades;

import vista.Parques.ParquesInsertController;
import Datos.GestionBD;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import modelo.Comunidad;

/**
 * FXML Controller class
 *
 * @author kokek
 */
public class VistaComunidadesController implements Initializable {

    private GestionBD gestion;
    private List<Comunidad> listadoComunidades = new ArrayList<>();
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfNombre;
    private ResultSet rs;
    private Integer id;
    private String nombre;
    private int posicionActual = 0;
    @FXML
    private Label lSizeComu;
    @FXML
    private Label lConexion;

    public VistaComunidadesController() {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void cargarLista() {
        try {
            listadoComunidades = gestion.rellenarListaComunidades();
            lSizeComu.setText(String.valueOf(listadoComunidades.size()));
            lConexion.setText("CONECTADO");
        } catch (SQLException ex) {
            Logger.getLogger(ParquesInsertController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Primero(ActionEvent event) throws SQLException {
        posicionActual = 0;
        nombre = listadoComunidades.get(posicionActual).getNombre();
        tfId.setText(String.valueOf(listadoComunidades.get(posicionActual).getId()));
        tfNombre.setText(nombre);
    }

    @FXML
    private void Anterior(ActionEvent event) {
        if (posicionActual != 0) {
            posicionActual = posicionActual - 1;
            nombre = listadoComunidades.get(posicionActual).getNombre();
            tfId.setText(String.valueOf(listadoComunidades.get(posicionActual).getId()));
            tfNombre.setText(nombre);
        }
    }

    @FXML
    private void Siguiente(ActionEvent event) {
        if (posicionActual < listadoComunidades.size() - 1) {// El -1 para controlar que no se salga del Array
            posicionActual = posicionActual + 1;
            nombre = listadoComunidades.get(posicionActual).getNombre();
            tfId.setText(String.valueOf(listadoComunidades.get(posicionActual).getId()));
            tfNombre.setText(nombre);
        }
    }

    @FXML
    private void Ultimo(ActionEvent event) {
        posicionActual = listadoComunidades.size() - 1;
        nombre = listadoComunidades.get(posicionActual).getNombre();
        tfId.setText(String.valueOf(listadoComunidades.get(posicionActual).getId()));
        tfNombre.setText(nombre);
    }

    public GestionBD getConn() {
        return gestion;
    }

    public void setConn(GestionBD gestion) {
        this.gestion = gestion;
    }

}
