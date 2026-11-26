/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import exceptions.TripuladaYNoException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import models.Agencia;
import models.Dispositivo;
import models.Mision;
import models.NoTripulada;
import models.Tripulada;

/**
 *
 * @author sofia
 */
public class MisionesController implements Initializable{
    
    @FXML
    private TextField txtID;
    
    @FXML
    private TextField txtNombre;
    
    @FXML
    private TextField txtDestino;
    
    @FXML
    private TextField txtPresupuesto;
    
    @FXML
    private TextField txtDuracion;
    
    @FXML
    private ListView<Agencia> lvAgencia;
    
    @FXML
    private TextField txtTripulante;
    
    @FXML
    private ListView<Dispositivo> lvDispositivo;
    
    private ArrayList<Agencia> agencias;
    private ArrayList<Dispositivo> dispositivos;
    private Mision mision;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        agencias = new ArrayList<>();
        dispositivos = new ArrayList<>();
        
        Gson gson = new Gson();
        Type determinaTipo = new TypeToken<ArrayList<Agencia>>() {}.getType();
        
        try(Reader reader = new FileReader("../saves/agencias.json")){
            agencias = gson.fromJson(reader, determinaTipo);
        }catch(Exception e){
            //fart
        }
        
        for (Agencia a : agencias){
            a.toString();
        }
        
        dispositivos.add(Dispositivo.ROVER);
        dispositivos.add(Dispositivo.SATELITE);
        dispositivos.add(Dispositivo.SONDA_ESPACIAL);

        this.lvAgencia.getItems().addAll(agencias);
        this.lvDispositivo.getItems().addAll(dispositivos);
    }
    
    
    
    public void setMision(Mision mision){
        
        if(mision != null){
        this.txtDestino.setText(mision.getDestino());
        this.txtPresupuesto.setText(String.valueOf(mision.getPresupuesto()));
        this.txtNombre.setText(mision.getNombre());
        this.txtDuracion.setText(String.valueOf(mision.getDuracion()));
        this.txtID.setText(String.valueOf(mision.getIdMision()));
        
        this.txtID.setDisable(true);
        }
    }
    
    public Mision getMision(){
        return this.mision;
    }
    
    public void confirma() throws TripuladaYNoException{
        String destino = this.txtDestino.getText();
        String nombre = this.txtNombre.getText();
        
        String id = this.txtID.getText();
        String presupuesto = this.txtPresupuesto.getText();
        String duracion = this.txtDuracion.getText();
        
        String tripulacion = this.txtTripulante.getText();
        
        Agencia agencia = this.lvAgencia.getSelectionModel().getSelectedItem();
        Dispositivo dispositivo = this.lvDispositivo.getSelectionModel().getSelectedItem();
        
        
        if(this.mision == null){
            if (dispositivo == null && tripulacion != null){
                Tripulada mision = new Tripulada(Integer.parseInt(tripulacion),
                Integer.parseInt(id),nombre, destino, Integer.parseInt(presupuesto),
                Integer.parseInt(duracion),agencia);
            }
            else if (tripulacion == null && dispositivo != null){
                NoTripulada mision = new NoTripulada(dispositivo,Integer.parseInt(id),nombre, 
                destino, Integer.parseInt(presupuesto),
                Integer.parseInt(duracion),agencia);
            }
            else{
                throw new TripuladaYNoException("ERROR: la mision no puede tener una tripulación y un dispositivo a la vez");
            }
        }
        else{
            this.mision.setAgencia(agencia);
            this.mision.setDuracion(Integer.parseInt(duracion));
            this.mision.setDestino(destino);
            this.mision.setNombre(nombre);
            this.mision.setPresupuesto(Integer.parseInt(presupuesto));
            
            if(this.mision.getClass() == Tripulada.class){
                this.mision.setTripulada(Integer.parseInt(tripulacion));
            }
        }
    }
    
}
