/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Kokekui
 */
public class Parques {

    private int idParque;
    private String nombre;
    private Double extension;
    private int idComunidad;

    public Parques(int idParque, String nombre, Double extension, int idComunidad) {
        this.idParque = idParque;
        this.nombre = nombre;
        this.extension = extension;
        this.idComunidad = idComunidad;
    }

    //GETS Y SETS
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
