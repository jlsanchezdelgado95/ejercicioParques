/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import vista.InsertController;
import vista.UpdateController;

/**
 *
 * @author Kokekui
 */
public class LoginController implements Initializable {

    private Label label;
    @FXML
    private Label lConexion;
    @FXML
    private TextField tfIdParque;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfExtension;
    @FXML
    private Button bGuardar;
    private Connection conn;
    @FXML
    private ComboBox<Comunidad> cbComunidades;
    private List<Comunidad> lista = new ArrayList<>();
    @FXML
    private Button bBorrar;
    @FXML
    private Button bModificar;
    @FXML
    private Button bInsertar;
    @FXML
    private TextField tfUsuario;
    @FXML
    private TextField tfContraseña;
    @FXML
    private Button bConectar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void rellenarListaComunidades() throws SQLException {
        String id, nombreMetodo;
        PreparedStatement ps = conn.prepareStatement("select * from comunidad");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {//Siguiente fila
            id = String.valueOf(rs.getInt("id"));
            nombreMetodo = rs.getString("nombre");
            Comunidad comu = new Comunidad(id, nombreMetodo);
            lista.add(comu);
        }
        System.out.println(lista.toString());
        cbComunidades.setItems(FXCollections.observableArrayList(lista));
        cbComunidades.getSelectionModel().selectFirst();
    }

    @FXML
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

    @FXML
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
            //RECOGEMOS  LA INFORMACION ESCRITA EN LA OTRA VENTANA
//            String usuario = datosBorrar;
//            if (usuario != null) {
//                label.setText("Nombre escrito: " + usuario);
//            }
        } catch (IOException ex) {
            System.out.println("ERROR IOExcepction:  No se encuentra la ventana");
        }
    }

    @FXML
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
            //RECOGEMOS  LA INFORMACION ESCRITA EN LA OTRA VENTANA
//            String usuario = datosBorrar;
//            if (usuario != null) {
//                label.setText("Nombre escrito: " + usuario);
//            }
        } catch (IOException ex) {
            System.out.println("ERROR IOExcepction:  No se encuentra la ventana de login");
        }
    }

    @FXML
    private void Insertar(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/vista/Insert.fxml"));
            root = loader.load();

            //OBTENER EL CONTROLADOR DE LA VENTANA
            InsertController datosBorrar = loader.getController();

            Stage escenario = new Stage();
            escenario.setTitle("Ventana para insertar");
            escenario.initModality(Modality.APPLICATION_MODAL);  // NO PERMITE ACCESO A LA VENTANA PRINCIPAL
            escenario.setScene(new Scene(root));
            escenario.showAndWait();

            //RECOGEMOS  LA INFORMACION ESCRITA EN LA OTRA VENTANA
//            String usuario = datosBorrar;
//            if (usuario != null) {
//                label.setText("Nombre escrito: " + usuario);
//            }
        } catch (IOException ex) {
            System.out.println("ERROR IOExcepction:  No se encuentra la ventana de login");
        }
    }

    @FXML
    private void Conectar(ActionEvent event) {
        String urlJDBC = "jdbc:mysql://localhost:3306/" + "parques";
        try {
            conn = DriverManager.getConnection(urlJDBC, tfUsuario.getText(), tfContraseña.getText());
            if (conn.isValid(0)) {
                lConexion.setText("CONECTADO");
                rellenarListaComunidades();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
