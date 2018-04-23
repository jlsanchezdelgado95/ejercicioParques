/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Datos.GestionBD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kokek
 */
public class OpcionesController implements Initializable {

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    private GestionBD gestion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Insertar(ActionEvent event) throws SQLException {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/vista/Insert.fxml"));
            root = loader.load();
            //OBTENER EL CONTROLADOR DE LA VENTANA
            InsertController datosInsert = loader.getController();
            datosInsert.setGestion(gestion);
            Stage escenario = new Stage();
            escenario.setTitle("Ventana para insertar");
            escenario.initModality(Modality.APPLICATION_MODAL); // NO PERMITE ACCESO A LA VENTANA PRINCIPAL
            escenario.setScene(new Scene(root));
            escenario.showAndWait();
        } catch (IOException ex) {
            System.out.println("ERROR IOExcepction:  No se encuentra la ventana de insertar");
            ex.printStackTrace();
        }
    }

    @FXML
    private void Borrar(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/vista/Delete.fxml"));
            root = loader.load();
            //OBTENER EL CONTROLADOR DE LA VENTANA
            DeleteController datos = loader.getController();
            Stage escenario = new Stage();
            escenario.setTitle("Ventana para borrar");
            escenario.initModality(Modality.APPLICATION_MODAL); // NO PERMITE ACCESO A LA VENTANA PRINCIPAL
            escenario.setScene(new Scene(root));
            escenario.showAndWait();
        } catch (IOException ex) {
            System.out.println("ERROR IOExcepction:  No se encuentra la ventana de borrar");
            ex.getStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Modificar(ActionEvent event) {
    }

    @FXML
    private void verComunidades(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/vista/vistaComunidades.fxml"));
            root = loader.load();
            //OBTENER EL CONTROLADOR DE LA VENTANA
            VistaComunidadesController datos = loader.getController();
            datos.setConn(gestion);
            Stage escenario = new Stage();
            escenario.setTitle("Ventana para borrar");
            escenario.initModality(Modality.APPLICATION_MODAL); // NO PERMITE ACCESO A LA VENTANA PRINCIPAL
            escenario.setScene(new Scene(root));
            escenario.showAndWait();
        } catch (IOException ex) {
            System.out.println("ERROR IOExcepction:  No se encuentra la ventana de borrar");
            ex.printStackTrace();
        }
    }

    public GestionBD getGestion() {
        return gestion;
    }

    public void setGestion(GestionBD gestion) {
        this.gestion = gestion;
    }

}
