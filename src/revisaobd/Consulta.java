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
public class Consulta extends Application{
     private static Stage primaryStage;
     private AnchorPane principal;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    
    
     @Override
    public void start(Stage primaryStage){
        primaryStage.initStyle(StageStyle.UNDECORATED);

        Consulta.primaryStage = primaryStage;
        Consulta.primaryStage.setTitle("Gerencia de Estoque");
      initMain();
    }
       private void initMain(){
        try{
         String url = "/views/TelaConsulta.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
            Consulta.primaryStage.setScene(scene);
            Consulta.primaryStage.setResizable(false);
            Consulta.primaryStage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
                   launch(args);
 
           
    }

  
    
}
