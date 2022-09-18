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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author usuario
 */
public class Editar extends Application {
    
    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    
     @Override
    public void start(Stage primaryStage) throws Exception {
        Editar.primaryStage = primaryStage;
        initMain();
    }
     private void initMain(){
        try{
        String url = "/views/TelaEditar.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
        Parent root = loader.load();
        Scene scene = new Scene(root);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
       launch(args);
  
    }

   
    
   }
    
    
    
     