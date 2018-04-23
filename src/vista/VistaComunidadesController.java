/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Datos.GestionBD;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kokek
 */
public class VistaComunidadesController implements Initializable {

    private GestionBD conn;
    private List<String> listadoComunidades = new ArrayList<>();
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfNombre;
    private ResultSet rs;
    private Integer id;
    private String nombre;

    public VistaComunidadesController() {
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cargarLista();
        } catch (SQLException ex) {
            Logger.getLogger(VistaComunidadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarLista() throws SQLException {
        listadoComunidades = conn.rellenarListaComunidades();
    }

    @FXML
    private void Primero(ActionEvent event) throws SQLException {
        rs.first();
        tfId.setText(String.valueOf(id));
        tfNombre.setText(nombre);
    }

    @FXML
    private void Anterior(ActionEvent event) {
    }

    @FXML
    private void Siguiente(ActionEvent event) {
    }

    @FXML
    private void Ultimo(ActionEvent event) {
    }

    public GestionBD getConn() {
        return conn;
    }

    public void setConn(GestionBD conn) {
        this.conn = conn;
    }

}
