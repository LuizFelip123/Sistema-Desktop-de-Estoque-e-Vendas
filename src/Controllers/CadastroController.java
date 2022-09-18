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
import revisaobd.Cadastro;
import revisaobd.Consulta;
import revisaobd.Login;
import revisaobd.Principal;

/**
 *
 * @author usuario
 */
public class CadastroController implements Initializable{
    @FXML
    private TextField textQuantidade;

    @FXML
    private TextField textCod;

    @FXML
    private TextField textValor;
    @FXML
    private Button buttonSair;
    @FXML
    private Button buttonCadastrar, buttonPrincipal, buttonEstoque;

    @FXML
    private TextField textTipo;

    @FXML
    private TextField textMarca;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
       buttonCadastrar.setOnMouseClicked((MouseEvent e)->{
        Produto produto = new Produto();
        produto.setCodigo( Integer.parseInt(textCod.getText()));
        produto.setMarca(textMarca.getText());
        produto.setQuantidade(Integer.parseInt(textQuantidade.getText()));
        produto.setTipo(textTipo.getText());
        produto.setValor(Double.valueOf(textValor.getText().replace(",", ".")));
         DAO.save(produto);
         Consulta consulta = new Consulta();
         consulta.start(new Stage());
         Consulta.getPrimaryStage().show();
         fechar();
       });
       
       buttonPrincipal.setOnMouseClicked((MouseEvent e)->{
           Principal principal = new Principal();
           principal.start(new Stage());
           Principal.getPrimaryStage().show();
           fechar();
           
       });
       
       buttonEstoque.setOnMouseClicked((MouseEvent e)->{
           Consulta consulta = new Consulta();
           consulta.start(new Stage());
           Consulta.getPrimaryStage().show();
           fechar();
       }); 
       buttonSair.setOnMouseClicked((MouseEvent e)->{
       Login login = new Login();
           login.start(new Stage());
           Login.getState().show();
           fechar();
       
       });
       
    }
     private void fechar(){
         Cadastro.getPrimaryStage().close();
    }
}
