/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author sofia
 */
public class Tripulada extends Mision{
    private int astronautas;

    public Tripulada(int astronautas, int idMision, String nombre, String destino, int presupuesto, int duracion, Agencia agencia) {
        super(idMision, nombre, destino, presupuesto, duracion, agencia);
        this.astronautas = astronautas;
    }    
    
    
}
