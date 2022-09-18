/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisaobd;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.omg.PortableServer.POAManagerPackage.State;
/**
 *
 * @author usuario
 */
public class Login extends Application {
    private static Stage primaryStage;
    private AnchorPane principal;
    @Override
    public void start(Stage primaryStage) {
        Login.primaryStage = primaryStage;
        Login.primaryStage.setTitle("Gerencia de Estoque");
        initMain();
    }
    private void initMain(){
        try{
         String url = "/views/TelaLogin.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
        Parent root = loader.load();
        Scene scene = new Scene(root);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            Login.primaryStage.setScene(scene);
            Login.primaryStage.setResizable(false);
            Login.primaryStage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static Stage getState(){ 
          return primaryStage;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
