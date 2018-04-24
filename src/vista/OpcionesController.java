/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import vista.Comunidades.VistaComunidadesController;
import vista.Parques.ParquesDeleteController;
import vista.Parques.ParquesInsertController;
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
import vista.Parques.VistaParquesController;

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
    private void verComunidades(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/vista/Comunidades/vistaComunidades.fxml"));
            root = loader.load();
            //OBTENER EL CONTROLADOR DE LA VENTANA
            VistaComunidadesController datos = loader.getController();
            datos.setConn(gestion);
            datos.cargarLista();
            Stage escenario = new Stage();
            escenario.setTitle("Ventana para borrar");
            escenario.initModality(Modality.APPLICATION_MODAL); // NO PERMITE ACCESO A LA VENTANA PRINCIPAL
            escenario.setScene(new Scene(root));
            escenario.showAndWait();
        } catch (IOException ex) {
            System.out.println("ERROR IOExcepction:  No se encuentra la ventana de borrar");
        }
    }

    public GestionBD getGestion() {
        return gestion;
    }

    public void setGestion(GestionBD gestion) {
        this.gestion = gestion;
    }

    @FXML
    private void verParques(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/vista/Parques/VistaParques.fxml"));
            root = loader.load();
            //OBTENER EL CONTROLADOR DE LA VENTANA
            VistaParquesController datos = loader.getController();
            datos.setGestion(gestion);
            datos.cargarParques();
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

    @FXML
    private void InsertarParque(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/vista/Parques/Insert.fxml"));
            root = loader.load();
            //OBTENER EL CONTROLADOR DE LA VENTANA
            ParquesInsertController datosInsert = loader.getController();
            datosInsert.setGestion(gestion);
            datosInsert.cargarLista();
            Stage escenario = new Stage();
            escenario.setTitle("Ventana para insertar");
            escenario.initModality(Modality.APPLICATION_MODAL); // NO PERMITE ACCESO A LA VENTANA PRINCIPAL
            escenario.setScene(new Scene(root));
            escenario.showAndWait();
        } catch (IOException ex) {
            System.out.println("ERROR IOExcepction:  No se encuentra la ventana de insertar");
        }
    }

    @FXML
    private void BorrarParque(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/vista/Parques/Delete.fxml"));
            root = loader.load();
            //OBTENER EL CONTROLADOR DE LA VENTANA
            ParquesDeleteController datosborrar = loader.getController();
            datosborrar.setGestion(gestion);
            datosborrar.cargarParques();
            Stage escenario = new Stage();
            escenario.setTitle("Ventana para borrar");
            escenario.initModality(Modality.APPLICATION_MODAL); // NO PERMITE ACCESO A LA VENTANA PRINCIPAL
            escenario.setScene(new Scene(root));
            escenario.showAndWait();
        } catch (IOException ex) {
            System.out.println("ERROR IOExcepction:  No se encuentra la ventana de borrar");
        }
    }

    @FXML
    private void ModificarParque(ActionEvent event) {
    }

    @FXML
    private void InsertarComunidad(ActionEvent event) {
    }

    @FXML
    private void ModificarComunidad(ActionEvent event) {
    }

    @FXML
    private void BorrarComunidad(ActionEvent event) {
    }

}
