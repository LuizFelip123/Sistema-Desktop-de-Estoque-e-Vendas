/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisaobd;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author usuario
 */
public class Cadastro extends Application  {
     private static Stage primaryStage;
     private AnchorPane principal;
    
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    
    @Override
    public void start(Stage primaryStage) {
                    primaryStage.initStyle(StageStyle.UNDECORATED);

        Cadastro.primaryStage = primaryStage;
        initMain(); 
    }
    
   
     private void initMain() {
        try{
        String url = "/views/TelaCadastroProduto.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
            Cadastro.primaryStage.setScene(scene);
            Cadastro.primaryStage.setResizable(false);
            Cadastro.primaryStage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
          launch(args);

    }
  
}
