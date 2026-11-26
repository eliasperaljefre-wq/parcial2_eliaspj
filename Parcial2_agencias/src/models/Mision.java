/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author sofia
 */
public abstract class Mision {
    private int idMision;
    private String nombre;
    private String destino;
    private int presupuesto;
    private int duracion;
    private Agencia agencia;

    public Mision(int idMision, String nombre, String destino, int presupuesto, int duracion, Agencia agencia) {
        this.idMision = idMision;
        this.nombre = nombre;
        this.destino = destino;
        this.presupuesto = presupuesto;
        this.duracion = duracion;
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "Mision{" + "idMision=" + idMision + ", nombre=" + nombre + ", destino=" + destino + ", presupuesto=" + presupuesto + ", duracion=" + duracion + ", agencia=" + agencia + '}';
    }

    public int getIdMision() {
        return idMision;
    }

    public void setIdMision(int idMision) {
        this.idMision = idMision;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    
    
    
    
}
