/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rafar e rita
 */
public class Semaforo extends Application {
    
    
//    jogador[]jogadores;
//    peca[]pecas;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLSemaforo.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        
        scene.getStylesheets().add(Semaforo.class.getResource("styles.css").toExternalForm());
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
