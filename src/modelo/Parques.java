/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Kokekui
 */
public class Parques {

    private int idParque;
    private String nombre;
    private Double extension;
    private int idComunidad;
    private final IntegerProperty idParqueFX = new SimpleIntegerProperty();
    private final StringProperty nombreParqueFX = new SimpleStringProperty();
    private final DoubleProperty extensionFX = new SimpleDoubleProperty();

    public Parques(int idParque, String nombre, Double extension, int idComunidad) {
        this.idParque = idParque;
        this.nombre = nombre;
        this.extension = extension;
        this.idComunidad = idComunidad;
        idParqueFX.set(idParque);
        nombreParqueFX.set(nombre);
        extensionFX.set(extension);
    }

    public int getIdParqueFX() {
        return idParqueFX.get();
    }

    public void setIdParqueFX(int value) {
        idParqueFX.set(value);
    }

    public IntegerProperty idParqueFXProperty() {
        return idParqueFX;
    }

    //GETS Y SETS
    public double getExtensionFX() {
        return extensionFX.get();
    }

    public void setExtensionFX(double value) {
        extensionFX.set(value);
    }

    public DoubleProperty extensionFXProperty() {
        return extensionFX;
    }

    public String getNombreParqueFX() {
        return nombreParqueFX.get();
    }

    public void setNombreParqueFX(String value) {
        nombreParqueFX.set(value);
    }

    public StringProperty nombreParqueFXProperty() {
        return nombreParqueFX;
    }

    public int getIdParque() {
        return idParque;
    }

    public void setIdParque(int idParque) {
        this.idParque = idParque;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getExtension() {
        return extension;
    }

    public void setExtension(Double extension) {
        this.extension = extension;
    }

    public int getIdComunidad() {
        return idComunidad;
    }

    public void setIdComunidad(int idComunidad) {
        this.idComunidad = idComunidad;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
