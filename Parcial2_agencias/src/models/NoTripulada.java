/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author sofia
 */
public class NoTripulada extends Mision{
    private Dispositivo dispositivo;

    public NoTripulada(Dispositivo dispositivo, int idMision, String nombre, String destino, int presupuesto, int duracion, Agencia agencia) {
        super(idMision, nombre, destino, presupuesto, duracion, agencia);
        this.dispositivo = dispositivo;
    }
    
    
}
