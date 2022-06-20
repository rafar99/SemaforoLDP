/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;


/**
 *
 * @author rafar
 */
public class FXMLDocumentController {
    
    @FXML
    private Button btn_voltar;
    @FXML
    private GridPane gp_tabuleiro;
    @FXML
    private Pane p_menu;
    @FXML
    private Pane p_jogo;
    
    private Estado dados;
    
    
    public void initialize() {
        p_jogo.setVisible(false);
        
        
        this.dados = new Estado();
        int i,j;
        Casa tabuleiro[][] = this.dados.getTabuleiro();
        
         for(i = 0; i < 3; i++){
            for(j = 0; j < 4; j++){
                System.out.println(i + "," + j);
                Casa elem = tabuleiro[i][j];
                elem.setColumn(j);
                elem.setIndex(i);
                Verde cel = new Verde();
                cel.setOnMouseClicked(this::joga_ronda);
                
                GridPane.setRowIndex(cel, i);
                GridPane.setColumnIndex(cel, j);

                this.gp_tabuleiro.getChildren().add(cel);
            } 
        }
    }    
    
    private void joga_ronda(MouseEvent e) {
        Node source = (Node)e.getSource() ;
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
        
        // Verifica se pode adicionar a peça / alterar a peça
        boolean flag_valida = this.dados.verifica_jogada(rowIndex, colIndex);
        
        if (flag_valida){
            // Modifica a matriz local de 
            
            CasaVazia nodeCV = (CasaVazia) source;
            Verde nodeVe = (Verde) source;
            Amarela nodeA = (Amarela) source;
            Vermelha nodeV = (Vermelha) source;
            //node.atualizaCelula();
            
            if (TipoPeca.Casa_Vazia instanceof TipoPeca) {
                nodeCV.atualizaCelula();
                
            }
        } else{
            // mostra um alerta a dizer que a jogada é invalida
            return;
        }
        
        // Verifica se existe condição de vitória
        boolean flag_vitoria = this.dados.verifica_vitoria();
        if (flag_vitoria){
            //sai do jogo e/ou mostra um alerta
            System.out.println("Ganhei");
            return;
        }
        // Avança para o próximo jogador
        //this.dados.setJogador();
    }
}
