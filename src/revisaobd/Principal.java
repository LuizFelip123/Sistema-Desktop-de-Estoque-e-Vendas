/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisaobd;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
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
public class Principal extends Application{
    
    private static Stage primaryStage;
    private AnchorPane principal;
    
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.initStyle(StageStyle.UNDECORATED);

        Principal.primaryStage = primaryStage;
        Principal.primaryStage.setTitle("Gerencia de Estoque");
        initMain();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    
    
    private void initMain(){
        try{
         String url = "/views/TelaPrincipal.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
            Principal.primaryStage.setScene(scene);
            Principal.primaryStage.setResizable(false);
            Principal.primaryStage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
