/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Datos.GestionBD;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Comunidad;
import vista.DeleteController;
import vista.OpcionesController;
import vista.UpdateController;

/**
 *
 * @author Kokekui
 */
public class LoginController implements Initializable {

    private Label label;
    @FXML
    private Label lConexion;
    private TextField tfIdParque;
    private TextField tfNombre;
    private TextField tfExtension;
    private Connection conn;
    private ComboBox<Comunidad> cbComunidades;
    @FXML
    private TextField tfUsuario;
    @FXML
    private TextField tfContraseña;
    @FXML
    private Button bConectar;
    private GestionBD gestion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void Guardar(ActionEvent event) throws SQLException {
        String sql = ("insert into " + " parque(id,nombre,extension,idcomunidad) "
                + " values(?,?,?,?)");
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.valueOf(tfIdParque.getText()));
        ps.setString(2, tfNombre.getText());
        ps.setDouble(3, Double.valueOf(tfExtension.getText()));
        ps.setInt(4, Integer.valueOf(cbComunidades.getSelectionModel().getSelectedItem().getId()));
        int numFilas = ps.executeUpdate();//Se ejecuta el insert
        if (numFilas > 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacion");
            alert.setHeaderText("Mas informacion");
            alert.setContentText("Se ha introducido correctamente");
            alert.showAndWait();
        }
    }

    private void Borrar(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/vista/Delete.fxml"));
            root = loader.load();
            //OBTENER EL CONTROLADOR DE LA VENTANA
            DeleteController datosBorrar = loader.getController();
            Stage escenario = new Stage();
            escenario.setTitle("Ventana para borrar");
            escenario.initModality(Modality.APPLICATION_MODAL);  // NO PERMITE ACCESO A LA VENTANA PRINCIPAL
            escenario.setScene(new Scene(root));
            escenario.showAndWait();
        } catch (IOException ex) {
            System.out.println("ERROR IOExcepction:  No se encuentra la ventana");
        }
    }

    private void Modificar(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/vista/Update.fxml"));
            root = loader.load();
            //OBTENER EL CONTROLADOR DE LA VENTANA
            UpdateController datosBorrar = loader.getController();
            Stage escenario = new Stage();
            escenario.setTitle("Ventana para modificar");
            escenario.initModality(Modality.APPLICATION_MODAL);  // NO PERMITE ACCESO A LA VENTANA PRINCIPAL
            escenario.setScene(new Scene(root));
            escenario.showAndWait();
        } catch (IOException ex) {
            System.out.println("ERROR IOExcepction:  No se encuentra la ventana de Modificar");
        }
    }

    @FXML
    private void Conectar(ActionEvent event) {
        gestion = new GestionBD(tfUsuario.getText(), tfContraseña.getText());
        if (gestion.conexion()) {
            lConexion.setText("CONECTADO");
            Parent root;
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/vista/Opciones.fxml"));
                root = loader.load();
                //OBTENER EL CONTROLADOR DE LA VENTANA
                OpcionesController datos = loader.getController();
                datos.setConn(gestion);
                Stage escenario = new Stage();
                escenario.setTitle("Opciones");
                escenario.initModality(Modality.APPLICATION_MODAL);  // NO PERMITE ACCESO A LA VENTANA PRINCIPAL
                escenario.setScene(new Scene(root));
                escenario.showAndWait();
            } catch (IOException ex) {
                System.out.println("ERROR IOExcepction:  No se encuentra la ventana de opciones");
                ex.printStackTrace();
            }
        } else {
            lConexion.setText("NO CONECTADO");
        }
    }
}
