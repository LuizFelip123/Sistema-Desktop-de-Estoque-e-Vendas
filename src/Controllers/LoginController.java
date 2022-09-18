/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import revisaobd.Principal;
import revisaobd.Login;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class LoginController implements Initializable {
    @FXML
    private Button buttonClose;

    @FXML
    private  TextField campoUser;
    @FXML
    private PasswordField campoSenha;
    @FXML
    private Button entrar;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       buttonClose.setOnMouseClicked((MouseEvent e)->{
           fechar();
       });
        entrar.setOnMouseClicked((MouseEvent e)->{
                    verificar();
           
        });
        campoSenha.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
             verificar();
            }
        });
    }
    private void fechar(){
       Login.getState().close();
    }
    private void loggar(){
      Principal principal = new Principal();
      principal.start(new Stage());
      fechar();
    }
    private void verificar(){
      if(campoUser.getText().equals("Luiz") && campoSenha.getText().equals("123")){
                loggar();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Erro!");
                alert.setTitle("Erro");
                alert.setContentText("Senha ou Usuário incorreto!");
                alert.show();
            }
    
    }
}
