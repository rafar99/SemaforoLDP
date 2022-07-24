/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import Client.ClientConnection;
import java.util.List;
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
        private ClientConnection client_con;
    
    public void conectToServer(FXMLDocumentController cont) throws Exception{
        this.client_con = new ClientConnection(cont);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSemaforo.fxml"));
        Parent root = loader.load();
        
        FXMLDocumentController controller = loader.getController();
        this.conectToServer(controller);
        controller.setClient(this.client_con);
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
