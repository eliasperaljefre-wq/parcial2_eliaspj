/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial2_agencias;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author sofia
 */
public class LauncherInicio extends Application{
    
        public LauncherInicio() {
        }
        
        @Override
        public void start(Stage stage) throws Exception{
            
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/viewInicio.fxml"));
        Parent root = loader.load();
        

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();}
        catch (IOException e){
            //fart
        }
    }
    
}
