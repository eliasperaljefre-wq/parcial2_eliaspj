/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author sofia
 */
public class Agencia {
    private double id;
    private String nombre;
    private String pais;
    private double anioFundacion;
    private String email;

    public Agencia(double id, String nombre, String pais, double anioFundacion, String email) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.anioFundacion = anioFundacion;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Agencia{" + "id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", anioFundacion=" + anioFundacion + ", email=" + email + '}';
    }
    
    
}
