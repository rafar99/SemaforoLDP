/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author rafar
 */
public class FXMLDocumentController implements Initializable{
    
   
    private Estado dados;
    
    @FXML
    private GridPane gp_tabuleiro;
    @FXML
    private Label label;
    @FXML
    private Button btn_voltar;
    @FXML
    private Button btn_comecar;
 
    @FXML
    private Pane p_id;
    @FXML
    private Pane p_jogo;
    @FXML
    private Label lb_bemVindo;
    @FXML
    private Pane p_começar;
    @FXML
    private TextField txf_ip;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        this.dados = new Estado();
//        int i,j;
//        Casa tabuleiro[][] = this.dados.getTabuleiro();
//        
//         for(i = 0; i < 3; i++){
//            for(j = 0; j < 4; j++){
//                System.out.println(i + "," + j);
//                Casa elem = tabuleiro[i][j];
//                elem.setColumn(j);
//                elem.setIndex(i);
//                Celula cel = new Celula(elem.getPeça().getImg(), elem);
//                cel.setOnMouseClicked(this::joga_ronda);
//                
//                GridPane.setRowIndex(cel, i);
//                GridPane.setColumnIndex(cel, j);
//
//                this.gp_tabuleiro.getChildren().add(cel);
//            } 
//        }
        novo_jogo();
    }    
    
    private void novo_jogo(){
        this.dados = new Estado();
        int i,j;
        Casa tabuleiro[][] = this.dados.getTabuleiro();
        
         for(i = 0; i < 3; i++){
            for(j = 0; j < 4; j++){
                System.out.println(i + "," + j);
                Casa elem = tabuleiro[i][j];
                elem.setColumn(j);
                elem.setIndex(i);
                Celula cel = new Celula(elem.getPeça().getImg(), elem);
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
        System.out.printf("Mouse entered cell [%d, %d]%n", rowIndex.intValue(), colIndex.intValue());
        
        // Verifica se pode adicionar a peça / alterar a peça
        boolean flag_valida = this.dados.verifica_jogada(rowIndex, colIndex);
        
        if (flag_valida){
            // Modifica a matriz local de 
            
           Celula node = (Celula) source;
            node.atualizaCelula();
        } else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");

            alert.setHeaderText(null);
            alert.setContentText("Movimento Inválido!");
            alert.showAndWait();
            return;
        }
        
        // Verifica se existe condição de vitória
        boolean flag_vitoria = this.dados.venceuJogo();
        if (flag_vitoria){
            //sai do jogo e/ou mostra um alerta
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Vencedor");

            alert.setHeaderText(null);
            alert.setContentText("Lamento perdeste o jogo!");
            alert.showAndWait();
            System.out.println("Ganhei");
            p_começar.setVisible(true);
            p_jogo.setVisible(false);
            novo_jogo();
            
        }
        // Avança para o próximo jogador
        //this.dados.setJogador();
    }



    @FXML
    private void começar(MouseEvent event) throws IOException {
        p_começar.setVisible(false);
        p_jogo.setVisible(true);
        p_id.setVisible(false);
        //this.dados.cs.liga();
    }
    
    @FXML
    private void voltar(MouseEvent event){
        p_começar.setVisible(true);
        p_jogo.setVisible(true);
        p_id.setVisible(false);
    }
}
