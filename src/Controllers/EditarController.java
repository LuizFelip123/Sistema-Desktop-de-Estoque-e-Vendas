/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.DAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Produto;
import revisaobd.Consulta;
import revisaobd.Editar;
import revisaobd.Login;

/**
 *
 * @author usuario
 */
public class EditarController implements Initializable{
    @FXML
    private Button buttonVoltar;
    private static Produto produto;
    
    @FXML
    private TextField textQuantidade;
    
    @FXML
    private TextField textCod;

    @FXML
    private Button buttonSair;

    @FXML
    private TextField textValor;

    @FXML
    private Button buttonSalvar;

    @FXML
    private Button buttonExcluir;

    @FXML
    private TextField textTipo;

    @FXML
    private TextField textMarca;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonVoltar.setOnMouseClicked((MouseEvent e)->{
            Consulta consulta = new Consulta();
            consulta.start(new Stage());
            Consulta.getPrimaryStage().show();
            fechar();
            
        });
        iniciarTexts();
        buttonSalvar.setOnMouseClicked((MouseEvent e)->{
            produto.setCodigo(Integer.parseInt( textCod.getText()));
            produto.setMarca(textMarca.getText());
            produto.setTipo(textTipo.getText());
            produto.setQuantidade(Integer.parseInt(textQuantidade.getText()));
            produto.setValor(Double.parseDouble(textValor.getText()));
            DAO.update(produto);
            initConsulta();
        });
        buttonExcluir.setOnMouseClicked((MouseEvent e)->{
            DAO.delete(Integer.valueOf(textCod.getText()));
            initConsulta();
            fechar();
        });
        buttonSair.setOnMouseClicked((MouseEvent e)->{
        
         Login login = new Login();
           login.start(new Stage());
           Login.getState().show();
           fechar();
        });
    }
    private void initConsulta(){
    Consulta consulta = new Consulta();
    consulta.start(new Stage());
    Consulta.getPrimaryStage().show();
    fechar();
    }
    private void iniciarTexts(){
    textCod.setText(String.valueOf( produto.getCodigo()) );
    textMarca.setText(produto.getMarca());
    textQuantidade.setText(String.valueOf(produto.getQuantidade()));
    textTipo.setText(produto.getTipo());
    textValor.setText(String.valueOf(produto.getValor()));
    }
    private void fechar(){
        
        Editar.getPrimaryStage().close();
    }
    public static void setProduto(Produto produto){
        EditarController.produto = produto;
        
    }
    
}
