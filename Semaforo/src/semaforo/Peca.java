/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.io.Serializable;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

/**
 *
 * @author anari
 */

public class Peca {
    

    TipoPeca tipo;


    Peca(TipoPeca tipo) {
        this.tipo = tipo;
    }

    public TipoPeca getTipo() {
        return tipo;
    }
    
    
    

    
}
