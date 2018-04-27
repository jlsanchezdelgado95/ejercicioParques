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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Comunidad;
import modelo.Parques;

/**
 *
 * @author Kokekui
 */
public class GestionBD {

    private Connection conn;
    private String usuario;
    private String password;

    public GestionBD(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public boolean conexion() {
        boolean conectado = false;
        String urlJDBC = "jdbc:mysql://localhost:3306/" + "parques";
        try {
            conn = DriverManager.getConnection(urlJDBC, usuario, password);
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

    public int borrarParque(Integer idParque) throws SQLException {
        int filas = 0;
        String sql = ("delete from parque where id = ?");
        PreparedStatement ps = conn.prepareCall(sql);
        ps.setInt(1, idParque);
        filas = ps.executeUpdate();//Se ejecuta el delete
        return filas;
    }
    
    public int modificarParque(Integer idParqueViejo, String nombreViejo, int idParqueNuevo, String nombreNuevo, double extension, int idComunidad){
        int filas = 0;
        String sql = ("update parque set id = ? "
                + " set nombre = ?"
                + " set extension = ?"
                + " set idComunidad = ?"
                + "where id = ?"
                + " or nombre = ?");
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idParqueNuevo);
            ps.setString(2, nombreNuevo);
            ps.setDouble(3, extension);
            ps.setInt(4, idComunidad);
            ps.setInt(5, idParqueViejo);
            ps.setString(6, nombreViejo);
            filas = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filas;
    }

    public List rellenarListaComunidades() throws SQLException {
        List lista = new ArrayList();
        String id, nombreMetodo;
        String sql = ("select *" + " from comunidad");
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {//Siguiente fila
            id = String.valueOf(rs.getInt("id"));
            nombreMetodo = rs.getString("nombre");
            Comunidad comu = new Comunidad(id, nombreMetodo);
            lista.add(comu);
        }
        return lista;
    }

    public List rellenarListaParques() throws SQLException {
        List lista = new ArrayList();
        String nombreParque, extension, id, idComunidad;
        String sql = ("select *" + " from parque");
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {//Siguiente fila
            id = String.valueOf(rs.getInt("id"));
            nombreParque = rs.getString("nombre");
            extension = String.valueOf(rs.getDouble("extension"));
            idComunidad = String.valueOf(rs.getInt("idComunidad"));
            Parques parque = new Parques(Integer.parseInt(id), nombreParque, Double.parseDouble(extension), Integer.parseInt(idComunidad));
            lista.add(parque);
            System.out.println(parque);
        }
        System.out.println(lista);
        return lista;
    }

    public List buscarParques(int idComunidadMetodo) throws SQLException {
        List lista = new ArrayList();
        String nombreParque, extension, id, idComunidad;
        String sql = ("select *" + " from parque" + " where idComunidad = ?");
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idComunidadMetodo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            id = String.valueOf(rs.getInt("id"));
            nombreParque = rs.getString("nombre");
            extension = String.valueOf(rs.getDouble("extension"));
            idComunidad = String.valueOf(rs.getInt("idComunidad"));
            Parques parque = new Parques(Integer.parseInt(id), nombreParque, Double.parseDouble(extension), Integer.parseInt(idComunidad));
            lista.add(parque);
            System.out.println(parque);
        }
        return lista;
    }

//GETS Y SETS
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
