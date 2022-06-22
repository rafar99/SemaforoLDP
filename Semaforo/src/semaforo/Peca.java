/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

/**
 *
 * @author rafar e rita
 */
public class Peca {
    

    TipoPeca tipo;


    Peca(TipoPeca tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    public TipoPeca getTipo() {
        return tipo;
    }
}
