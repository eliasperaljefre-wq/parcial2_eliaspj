/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.Mision;

/**
 *
 * @author sofia
 */
public class viewController implements Initializable{
    @FXML
    private Button btnAñade;
    
    @FXML
    private Button btnElimina;
    
    @FXML
    private Button btnModifica;
    
    @FXML
    private Button btnGuarda;
    
    @FXML
    private Button btnImporta;
    
    @FXML
    private Button btnTotal;
    
    @FXML
    private Button btnAltoPresupuesto;
    
    @FXML
    private ListView<Mision> lvMisiones;
    
    ArrayList<Mision> misiones;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.misiones = new ArrayList<>();
    }
    
    public void abreCreadorEditor(Mision misionAnterior){
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/viewCreaMisiones.fxml"));
        Parent root = loader.load();
        
        MisionesController controller = loader.getController();
        controller.setMision(misionAnterior);
        
        Stage stage = new Stage();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.showAndWait();
        
        Mision misionFinal = controller.getMision();
        
        if (misionFinal != null){
            if (misionAnterior == null){
                if(!this.misiones.contains(misionFinal)){
                    misiones.add(misionFinal);
                }
            }
            this.actualizaMisionesLista();
        }
        
        }
        catch (IOException e){
            //fart
            }
        }
    
        private void actualizaMisionesLista(){
            this.lvMisiones.getItems().clear();
            this.lvMisiones.getItems().addAll(this.misiones);
        }
    
        public void añade(){
            //TODO: Excepcion por si hay un ID identico
            abreCreadorEditor(null);
        }
        
        public void modifica(){
            Mision misionPrevia = this.lvMisiones.getSelectionModel().getSelectedItem();
            
            if (misionPrevia != null){
                abreCreadorEditor(misionPrevia);
            }
        }
}
