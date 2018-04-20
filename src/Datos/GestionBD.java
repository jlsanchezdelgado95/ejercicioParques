/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Login.LoginController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Parques;

/**
 *
 * @author Kokekui
 */
public class GestionBD {

    private Connection conn;
    private String usuario;
    private String password;

    private boolean conexion() {
        boolean conectado = false;
        String urlJDBC = "jdbc:mysql://localhost:3306/" + "parques";
        try {
            conn = DriverManager.getConnection(urlJDBC, "root", "root");
            if (conn.isValid(0)) {
                conectado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conectado;
    }

    public int insertarParque(Parques p) throws SQLException {
        int filas = 0;
        String sql = ("insert into " + " parque(id,nombre,extension,idcomunidad) "
                + " values(?,?,?,?)");
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, p.getIdParque());
        ps.setString(2, p.getNombre());
        ps.setDouble(3, p.getExtension());
        ps.setInt(4, p.getIdComunidad());
        filas = ps.executeUpdate();//Se ejecuta el insert
        return filas;
    }

}
